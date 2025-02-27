package cn.hutool.core.convert;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumberWordFormatTest {

	@Test
	public void formatTest() {
		final String format = NumberWordFormatter.format(100.23);
		assertEquals("ONE HUNDRED AND CENTS TWENTY THREE ONLY", format);

		final String format2 = NumberWordFormatter.format("2100.00");
		assertEquals("TWO THOUSAND ONE HUNDRED AND CENTS  ONLY", format2);

		final String format3 = NumberWordFormatter.format("1234567890123.12");
		assertEquals("ONE TRILLION TWO HUNDRED AND THIRTY FOUR BILLION FIVE HUNDRED AND SIXTY SEVEN MILLION EIGHT HUNDRED AND NINETY THOUSAND ONE HUNDRED AND TWENTY THREE AND CENTS TWELVE ONLY", format3);
	}

	@Test
	public void formatSimpleTest() {
		final String format1 = NumberWordFormatter.formatSimple(1200, false);
		assertEquals("1.2k", format1);

		final String format2 = NumberWordFormatter.formatSimple(4384324, false);
		assertEquals("4.38m", format2);

		final String format3 = NumberWordFormatter.formatSimple(4384324, true);
		assertEquals("438.43w", format3);

		final String format4 = NumberWordFormatter.formatSimple(4384324);
		assertEquals("438.43w", format4);

		final String format5 = NumberWordFormatter.formatSimple(438);
		assertEquals("438", format5);
	}

	@Test
	public void formatSimpleTest2(){
		final String s = NumberWordFormatter.formatSimple(1000);
		assertEquals("1k", s);
	}
}
