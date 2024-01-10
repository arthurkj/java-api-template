package br.com.akj.template.fixture;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.ObjectCreationException;

public class Fixture {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static <T> T make(final Class<T> type) {
        return type.isRecord() ? makeRandomRecord(type) : easyRandom.nextObject(type);
    }

    private static <T> T makeRandomRecord(Class<T> recordType) {
        List<Object> randomValues = Arrays.stream(recordType.getRecordComponents())
            .map(RecordComponent::getType)
            .map(Fixture::make)
            .collect(Collectors.toList());

        try {
            return getRecordConstrutor(recordType).newInstance(randomValues.toArray(Object[]::new));
        } catch (Exception e) {
            throw new ObjectCreationException("Unable to create a random instance of recordType " + recordType, e);
        }
    }

    private static <T> Constructor<T> getRecordConstrutor(Class<T> recordType) {
        List<Class<?>> componentTypes = Arrays.stream(recordType.getRecordComponents())
            .map(RecordComponent::getType)
            .collect(Collectors.toList());

        try {
            return recordType.getDeclaredConstructor(componentTypes.toArray(Class[]::new));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Invalid record definition", e);
        }
    }
}