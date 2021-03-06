package com.singh.primes;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class TestBigIntegerAKS {

	@Test
	public void testNthRoot() {
		BigIntegerAKS b0 = new BigIntegerAKS("2515456");
		assertTrue((double)136 == b0.bthRoot(3));
		
		BigIntegerAKS b1 = new BigIntegerAKS("283593393");
		assertTrue((double)657 == b1.bthRoot(3));
		
		BigIntegerAKS b2 = new BigIntegerAKS("22808058910723055197469457");
		assertTrue((double)283593393 == b2.bthRoot(3));
		
		BigIntegerAKS b3 = new BigIntegerAKS("16633604317637114693");
		assertTrue((double)557 == b3.bthRoot(7));
		
		BigIntegerAKS b4 = new BigIntegerAKS("166336043176371146932");
		assertTrue((double)557 != b4.bthRoot(7));
	}
	
	@Test
	public void testPerfectPower() {
		assertTrue(new BigIntegerAKS("283593393").isPerfectPower());
		assertTrue(new BigIntegerAKS("22808058910723055197469457").isPerfectPower());
		
		BigIntegerAKS b = new BigIntegerAKS("949488124966618051935859839144423206236498014439530858140704600418459988750856344627457493578020167941968639946777197784308179746313347363535367449187736210434705437");
		assertTrue(b.isPerfectPower());
		
		BigIntegerAKS b254Digits = new BigIntegerAKS("64792146116285445010150464657742422831740283983741698226696259982720258383066305682368147831715320742516920356617993173501638696147940336307203852906697710307237874649292733039111928819730348068189760517891070827221877089105483806498674276498905227691601");
		assertTrue(b254Digits.isPerfectPower());//^20
		
		BigIntegerAKS b267Digits = new BigIntegerAKS("317759456233126318207311239554587737587392419887095068551864853605600567217602537003527278386674217744740640997418526068823758704874533292581188107932737944666785176773254811757398066460308075222375839536598921443376902412099135772010936382320507376871017345049878717");
		assertTrue(b267Digits.isPerfectPower());//^21
		
		BigIntegerAKS b280Digits = new BigIntegerAKS("1558384435118952420951217965708513170692215844378278206330329307360430779151153185741421483765695432387157898028621776329968276354482329471898340107966439513217206829956969457407370020725138548166371893928055802774861468414703756146711887993529044565552905821983146391470555253689");
		assertTrue(4904289721517D == b280Digits.bthRoot(22));
		assertTrue(b280Digits.isPerfectPower());//^22
		
		BigIntegerAKS b318Digits = new BigIntegerAKS("183824315169896327482024447676881098390539608383453483171042883054468719737695835253519980129724479912905530165512292057576786786452123892263216571899537317852094402748696370241041451265105276464088832877388247035122135532561669708633303384578508662418162192908526038323652485599792034772471163295699882456179140028557");
		assertTrue(b318Digits.isPerfectPower());//ans: 4904289721517^25
	}

	
	@Test
	public void testOrderNModR() {
		assertTrue(new BigInteger("3").equals(new BigIntegerAKS("4").orderOfNModR(new BigInteger("7"))));
		assertTrue(new BigInteger("6").equals(new BigIntegerAKS("5").orderOfNModR(new BigInteger("7"))));
		assertTrue(new BigInteger("2550").equals(new BigIntegerAKS("5").orderOfNModR(new BigInteger("743454"))));
		//The following takes a very long time
//		assertTrue(new BigInteger("247817285970").equals(new BigIntegerAKS("5").orderOfNModR(new BigInteger("7434543523443"))));
	}
	
	@Test
	public void testR() {
		assertEquals(new BigInteger("29"), new BigIntegerAKS("31").calculateR());
	}

	@Test
	public void testLog2() {
		assertEquals(new Double(1), Double.valueOf(new BigIntegerAKS("2").log()/Math.log(2)));
	}
	
	@Test
	public void testGcdExists() {
		assertFalse(new BigIntegerAKS("31").gcdExists());
	}
	
	@Test
	public void testTotient() {
		assertEquals(new BigInteger("6"), new BigIntegerAKS("111").totient(new BigInteger("9")));
		assertEquals(new BigInteger("196992"), new BigIntegerAKS("111").totient(new BigInteger("213421")));
		assertEquals(new BigInteger("2021868"), new BigIntegerAKS("111").totient(new BigInteger("2134213")));
	}
}
