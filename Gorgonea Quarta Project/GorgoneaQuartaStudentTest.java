import java.util.Arrays;
import junit.framework.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * GorgoneaQuartaTest.java
 *
 * This is the test suite for the GorgoneaQuarta programming problem.
 *
 */
public class GorgoneaQuartaStudentTest extends TestCase {
    public void testGorgoneaQuarta01() {
        GQ_Decimal_Converter gq = new GQ_Decimal_Converter(  );
        assertEquals(10, GQ_Decimal_Converter.toDecimal("101"));
        assertEquals(2, GQ_Decimal_Converter.toDecimal("1-"));
        assertEquals(-17, GQ_Decimal_Converter.toDecimal("-101"));
        assertEquals(42, GQ_Decimal_Converter.toDecimal("1---0"));
        assertEquals(1024, GQ_Decimal_Converter.toDecimal("111-0-1"));

        assertEquals("101", GQ_Decimal_Converter.toGQ(10));
        assertEquals("1-", GQ_Decimal_Converter.toGQ(2));
        assertEquals("-101", GQ_Decimal_Converter.toGQ(-17));
        assertEquals("1---0", GQ_Decimal_Converter.toGQ(42));
        assertEquals("111-0-1", GQ_Decimal_Converter.toGQ(1024));
    }
}