package org.jboss.dmr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import org.junit.Test;


public class DoubleModelValueTest {

    @Test
    public void testDoubleModelValue() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertNotNull(value);
        assertEquals(ModelType.DOUBLE, value.getType());
        assertEquals(Double.valueOf(5), Double.valueOf(value.asDouble()));
    }

    @Test
    public void testWriteExternal() {
        //TODO implement test
    }

    @Test
    public void testAsLong() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(5l, value.asLong());
    }

    @Test
    public void testAsLongWithDefault() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(5l, value.asLong(10l));
    }

    @Test
    public void testAsInt() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(5, value.asInt());
    }

    @Test
    public void testAsIntWithDefault() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(5, value.asInt(10));
    }

    @Test
    public void testAsBoolean() {
        final DoubleModelValue value1 = new DoubleModelValue(5.0);
        assertEquals(true, value1.asBoolean());

        final DoubleModelValue value2 = new DoubleModelValue(0.0);
        assertEquals(false, value2.asBoolean());
    }

    @Test
    public void  testAsBooleanWithDefault() {
        final DoubleModelValue value1 = new DoubleModelValue(5.0);
        assertEquals(true, value1.asBoolean(false));

        final DoubleModelValue value2 = new DoubleModelValue(0.0);
        assertEquals(false, value2.asBoolean(true));
    }

    @Test
    public void testAsDouble() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(Double.valueOf(5), Double.valueOf(value.asDouble()));
    }

    @Test
    public void testAsDoubleWithDefault() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(Double.valueOf(5), Double.valueOf(value.asDouble(10.0)));
    }

    @Test
    public void testAsBytes() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(Double.valueOf(5), Double.valueOf(ByteBuffer.wrap(value.asBytes()).asDoubleBuffer().get()));
    }

    @Test
    public void testAsBigDecimal() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(new BigDecimal(5), value.asBigDecimal());
    }

    @Test
    public void testAsBigInteger() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals(BigInteger.valueOf(5), value.asBigInteger());
    }

    @Test
    public void testAsString() {
        final DoubleModelValue value = new DoubleModelValue(5.0);
        assertEquals("5.0", value.asString());
    }

    @Test
    public void testEqualsObject() {
        final DoubleModelValue value1 = new DoubleModelValue(5.0);
        final DoubleModelValue value2 = new DoubleModelValue(5.0);
        final DoubleModelValue value3 = new DoubleModelValue(10.0);

        assertEquals(true, value1.equals((Object)value1));
        assertEquals(true, value1.equals((Object)value2));
        assertEquals(true, value2.equals((Object)value1));
        assertEquals(false, value1.equals((Object)value3));
        assertEquals(false, value1.equals((Object)null));
        assertEquals(false, value1.equals("some string"));
    }

    @Test
    public void testEqualsDoubleModel() {
        final DoubleModelValue value1 = new DoubleModelValue(5.0);
        final DoubleModelValue value2 = new DoubleModelValue(5.0);
        final DoubleModelValue value3 = new DoubleModelValue(10.0);

        assertEquals(true, value1.equals(value1));
        assertEquals(true, value1.equals(value2));
        assertEquals(true, value2.equals(value1));
        assertEquals(false, value1.equals(value3));
        assertEquals(false, value1.equals((DoubleModelValue)null));
    }

    @Test
    public void testHashCode() {
        final DoubleModelValue value1 = new DoubleModelValue(5.0);
        final DoubleModelValue value2 = new DoubleModelValue(5.0);
        final DoubleModelValue value3 = new DoubleModelValue(10.0);

        assertEquals(true, value1.hashCode() == value1.hashCode());
        assertEquals(true, value1.hashCode() == value2.hashCode());
        assertEquals(false, value1.hashCode() == value3.hashCode());
    }
}
