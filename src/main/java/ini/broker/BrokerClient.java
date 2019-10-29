package ini.broker;

import java.lang.reflect.Type;
import java.util.function.Consumer;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import ini.IniEnv;
import ini.Main;
import ini.eval.data.Data;
import ini.eval.data.RawData;

public interface BrokerClient<T> {

	boolean VERBOSE = false;

	public static BrokerClient<Data> createDefaultInstance(IniEnv env, boolean global) {
		if (global && env.coreBrokerClient != null) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Data.class, new JsonDeserializer<RawData>() {
				@Override
				public RawData deserialize(JsonElement json, Type type, JsonDeserializationContext context)
						throws JsonParseException {
					RawData data = gsonBuilder.create().fromJson(json, RawData.class).tryNumerizeKeys()
							.applyTypeInfo(gsonBuilder);
					return data;
				}
			});
			Main.LOGGER.debug("creating kafka broker client");
			return new KafkaBrokerClient<>(VERBOSE, env.getEnvironmentConfiguration(), new ConsumerConfiguration<>(
					env.getEnvironmentConfiguration().consumerGroupId, gsonBuilder, Data.class));
		} else {
			Main.LOGGER.debug("creating local broker client");
			return LocalBrokerClient.getInstance(new ConsumerConfiguration<>());
		}
	}

	void produce(String channel, T data);

	void consume(String channel, Consumer<T> consumeHandler);

	void stopConsumer(String channel);

	boolean isConsumerRunning(String channel);

}
