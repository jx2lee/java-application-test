package com.jx2lee.junitbasic;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class JunitParameterizedTest {

    @ParameterizedTest(name = "{index}: {displayName}: message={arguments}")
    @ValueSource(strings = {"one", "two", "three", "four"})
    @EmptySource
    @NullSource
    void EmptySource_와_NullSource_로_빈_혹은_null_값으로_인자를_넘길_수_있다(String message) {
        System.out.println(": message = " + message);
    }


    @ParameterizedTest(name = "{index}: {displayName}: message={arguments}")
    @ValueSource(ints = {10, 20, 40})
    void 테스트하고_싶은_인자값을_객체_필드값으로_전달하기(@ConvertWith(ClassConverter.class) Class classObject) {
        System.out.println("classObject.getLimit() = " + classObject.getLimit());
    }

    static class ClassConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, java.lang.Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Class.class, targetType, "Class 객체로만 변경이 가능합니다.");
            return new Class(Integer.parseInt(source.toString()));
        }
    }

    @ParameterizedTest(name = "{index}: {displayName}: 순서대로 인자로 받아 객체를 생성하는 방법: V1: argument={arguments}")
    @CsvSource({"10, '띄어쓰기를 포함한 경우 홀따옴표를 쓴다'", "20, 테스트입니다"})
    void CsvSource_을_통해_인자값을_테스트에_넘겨준다V1(Integer limit, String member) {
        Class classInstance = new Class(limit, member);
        System.out.println(classInstance);
    }

    @ParameterizedTest(name = "{index}: {displayName}: argument={arguments}")
    @CsvSource({"10, '띄어쓰기를 포함한 경우 홀따옴표를 쓴다'", "20, 테스트입니다"})
    void CsvSource_을_통해_인자값을_테스트에_넘겨준다V2(@AggregateWith(ClassAggregator.class) Class classInstance) {
        System.out.println(classInstance.toString());
    }

    static class ClassAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Class(accessor.getInteger(0), accessor.getString(1));
        }
    }
}
