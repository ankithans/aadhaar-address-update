/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id$
 */

package auth_2_0.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Enum for allowed auth error codes
 *  
 * 
 * @version $Revision$ $Date$
 */
public class AuthErrorCode implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The 100 type
     */
    public static final int VALUE_100_TYPE = 0;

    /**
     * The instance of the 100 type
     */
    public static final AuthErrorCode VALUE_100 = new AuthErrorCode(VALUE_100_TYPE, "100");

    /**
     * The 200 type
     */
    public static final int VALUE_200_TYPE = 1;

    /**
     * The instance of the 200 type
     */
    public static final AuthErrorCode VALUE_200 = new AuthErrorCode(VALUE_200_TYPE, "200");

    /**
     * The 300 type
     */
    public static final int VALUE_300_TYPE = 2;

    /**
     * The instance of the 300 type
     */
    public static final AuthErrorCode VALUE_300 = new AuthErrorCode(VALUE_300_TYPE, "300");

    /**
     * The 310 type
     */
    public static final int VALUE_310_TYPE = 3;

    /**
     * The instance of the 310 type
     */
    public static final AuthErrorCode VALUE_310 = new AuthErrorCode(VALUE_310_TYPE, "310");

    /**
     * The 311 type
     */
    public static final int VALUE_311_TYPE = 4;

    /**
     * The instance of the 311 type
     */
    public static final AuthErrorCode VALUE_311 = new AuthErrorCode(VALUE_311_TYPE, "311");

    /**
     * The 312 type
     */
    public static final int VALUE_312_TYPE = 5;

    /**
     * The instance of the 312 type
     */
    public static final AuthErrorCode VALUE_312 = new AuthErrorCode(VALUE_312_TYPE, "312");

    /**
     * The 313 type
     */
    public static final int VALUE_313_TYPE = 6;

    /**
     * The instance of the 313 type
     */
    public static final AuthErrorCode VALUE_313 = new AuthErrorCode(VALUE_313_TYPE, "313");

    /**
     * The 314 type
     */
    public static final int VALUE_314_TYPE = 7;

    /**
     * The instance of the 314 type
     */
    public static final AuthErrorCode VALUE_314 = new AuthErrorCode(VALUE_314_TYPE, "314");

    /**
     * The 315 type
     */
    public static final int VALUE_315_TYPE = 8;

    /**
     * The instance of the 315 type
     */
    public static final AuthErrorCode VALUE_315 = new AuthErrorCode(VALUE_315_TYPE, "315");

    /**
     * The 316 type
     */
    public static final int VALUE_316_TYPE = 9;

    /**
     * The instance of the 316 type
     */
    public static final AuthErrorCode VALUE_316 = new AuthErrorCode(VALUE_316_TYPE, "316");

    /**
     * The 330 type
     */
    public static final int VALUE_330_TYPE = 10;

    /**
     * The instance of the 330 type
     */
    public static final AuthErrorCode VALUE_330 = new AuthErrorCode(VALUE_330_TYPE, "330");

    /**
     * The 400 type
     */
    public static final int VALUE_400_TYPE = 11;

    /**
     * The instance of the 400 type
     */
    public static final AuthErrorCode VALUE_400 = new AuthErrorCode(VALUE_400_TYPE, "400");

    /**
     * The 402 type
     */
    public static final int VALUE_402_TYPE = 12;

    /**
     * The 402 type
     */
    public static final int VALUE_403_TYPE = 108;

    /**
     * The instance of the 402 type
     */
    public static final AuthErrorCode VALUE_402 = new AuthErrorCode(VALUE_402_TYPE, "402");

    /**
     * The instance of the 403 type
     */
    public static final AuthErrorCode VALUE_403 = new AuthErrorCode(VALUE_403_TYPE, "403");

    /**
     * The 500 type
     */
    public static final int VALUE_500_TYPE = 13;

    /**
     * The instance of the 500 type
     */
    public static final AuthErrorCode VALUE_500 = new AuthErrorCode(VALUE_500_TYPE, "500");

    /**
     * The 501 type
     */
    public static final int VALUE_501_TYPE = 14;

    /**
     * The instance of the 501 type
     */
    public static final AuthErrorCode VALUE_501 = new AuthErrorCode(VALUE_501_TYPE, "501");

    /**
     * The 502 type
     */
    public static final int VALUE_502_TYPE = 15;

    /**
     * The instance of the 502 type
     */
    public static final AuthErrorCode VALUE_502 = new AuthErrorCode(VALUE_502_TYPE, "502");

    /**
     * The 503 type
     */
    public static final int VALUE_503_TYPE = 16;

    /**
     * The instance of the 503 type
     */
    public static final AuthErrorCode VALUE_503 = new AuthErrorCode(VALUE_503_TYPE, "503");

    /**
     * The 504 type
     */
    public static final int VALUE_504_TYPE = 17;

    /**
     * The instance of the 504 type
     */
    public static final AuthErrorCode VALUE_504 = new AuthErrorCode(VALUE_504_TYPE, "504");

    /**
     * The 505 type
     */
    public static final int VALUE_505_TYPE = 18;

    /**
     * The instance of the 505 type
     */
    public static final AuthErrorCode VALUE_505 = new AuthErrorCode(VALUE_505_TYPE, "505");

    /**
     * The 510 type
     */
    public static final int VALUE_510_TYPE = 19;

    /**
     * The instance of the 510 type
     */
    public static final AuthErrorCode VALUE_510 = new AuthErrorCode(VALUE_510_TYPE, "510");

    /**
     * The 511 type
     */
    public static final int VALUE_511_TYPE = 20;

    /**
     * The instance of the 511 type
     */
    public static final AuthErrorCode VALUE_511 = new AuthErrorCode(VALUE_511_TYPE, "511");

    /**
     * The 512 type
     */
    public static final int VALUE_512_TYPE = 21;

    /**
     * The instance of the 512 type
     */
    public static final AuthErrorCode VALUE_512 = new AuthErrorCode(VALUE_512_TYPE, "512");

    /**
     * The 513 type
     */
    public static final int VALUE_513_TYPE = 22;

    /**
     * The instance of the 513 type
     */
    public static final AuthErrorCode VALUE_513 = new AuthErrorCode(VALUE_513_TYPE, "513");

    /**
     * The 520 type
     */
    public static final int VALUE_520_TYPE = 23;

    /**
     * The instance of the 520 type
     */
    public static final AuthErrorCode VALUE_520 = new AuthErrorCode(VALUE_520_TYPE, "520");

    /**
     * The 521 type
     */
    public static final int VALUE_521_TYPE = 24;

    /**
     * The instance of the 521 type
     */
    public static final AuthErrorCode VALUE_521 = new AuthErrorCode(VALUE_521_TYPE, "521");

    /**
     * The 524 type
     */
    public static final int VALUE_524_TYPE = 25;

    /**
     * The instance of the 524 type
     */
    public static final AuthErrorCode VALUE_524 = new AuthErrorCode(VALUE_524_TYPE, "524");

    /**
     * The 527 type
     */
    public static final int VALUE_527_TYPE = 26;

    /**
     * The instance of the 527 type
     */
    public static final AuthErrorCode VALUE_527 = new AuthErrorCode(VALUE_527_TYPE, "527");

    /**
     * The 528 type
     */
    public static final int VALUE_528_TYPE = 27;

    /**
     * The instance of the 528 type
     */
    public static final AuthErrorCode VALUE_528 = new AuthErrorCode(VALUE_528_TYPE, "528");

    /**
     * The 530 type
     */
    public static final int VALUE_530_TYPE = 28;

    /**
     * The instance of the 530 type
     */
    public static final AuthErrorCode VALUE_530 = new AuthErrorCode(VALUE_530_TYPE, "530");

    /**
     * The 540 type
     */
    public static final int VALUE_540_TYPE = 29;

    /**
     * The instance of the 540 type
     */
    public static final AuthErrorCode VALUE_540 = new AuthErrorCode(VALUE_540_TYPE, "540");

    /**
     * The 541 type
     */
    public static final int VALUE_541_TYPE = 30;

    /**
     * The instance of the 541 type
     */
    public static final AuthErrorCode VALUE_541 = new AuthErrorCode(VALUE_541_TYPE, "541");

    /**
     * The 542 type
     */
    public static final int VALUE_542_TYPE = 31;

    /**
     * The instance of the 542 type
     */
    public static final AuthErrorCode VALUE_542 = new AuthErrorCode(VALUE_542_TYPE, "542");

    /**
     * The 543 type
     */
    public static final int VALUE_543_TYPE = 32;

    /**
     * The instance of the 543 type
     */
    public static final AuthErrorCode VALUE_543 = new AuthErrorCode(VALUE_543_TYPE, "543");

    /**
     * The 550 type
     */
    public static final int VALUE_550_TYPE = 33;

    /**
     * The instance of the 550 type
     */
    public static final AuthErrorCode VALUE_550 = new AuthErrorCode(VALUE_550_TYPE, "550");

    /**
     * The 551 type
     */
    public static final int VALUE_551_TYPE = 34;

    /**
     * The instance of the 551 type
     */
    public static final AuthErrorCode VALUE_551 = new AuthErrorCode(VALUE_551_TYPE, "551");

    /**
     * The 552 type
     */
    public static final int VALUE_552_TYPE = 35;

    /**
     * The instance of the 552 type
     */
    public static final AuthErrorCode VALUE_552 = new AuthErrorCode(VALUE_552_TYPE, "552");

    /**
     * The 553 type
     */
    public static final int VALUE_553_TYPE = 36;

    /**
     * The instance of the 553 type
     */
    public static final AuthErrorCode VALUE_553 = new AuthErrorCode(VALUE_553_TYPE, "553");

    /**
     * The 554 type
     */
    public static final int VALUE_554_TYPE = 37;

    /**
     * The instance of the 554 type
     */
    public static final AuthErrorCode VALUE_554 = new AuthErrorCode(VALUE_554_TYPE, "554");

    /**
     * The 555 type
     */
    public static final int VALUE_555_TYPE = 38;

    /**
     * The instance of the 555 type
     */
    public static final AuthErrorCode VALUE_555 = new AuthErrorCode(VALUE_555_TYPE, "555");

    /**
     * The 556 type
     */
    public static final int VALUE_556_TYPE = 39;

    /**
     * The instance of the 556 type
     */
    public static final AuthErrorCode VALUE_556 = new AuthErrorCode(VALUE_556_TYPE, "556");

    /**
     * The 557 type
     */
    public static final int VALUE_557_TYPE = 40;

    /**
     * The instance of the 557 type
     */
    public static final AuthErrorCode VALUE_557 = new AuthErrorCode(VALUE_557_TYPE, "557");

    /**
     * The 558 type
     */
    public static final int VALUE_558_TYPE = 41;

    /**
     * The instance of the 558 type
     */
    public static final AuthErrorCode VALUE_558 = new AuthErrorCode(VALUE_558_TYPE, "558");

    /**
     * The 559 type
     */
    public static final int VALUE_559_TYPE = 42;

    /**
     * The instance of the 559 type
     */
    public static final AuthErrorCode VALUE_559 = new AuthErrorCode(VALUE_559_TYPE, "559");

    /**
     * The 560 type
     */
    public static final int VALUE_560_TYPE = 43;

    /**
     * The instance of the 560 type
     */
    public static final AuthErrorCode VALUE_560 = new AuthErrorCode(VALUE_560_TYPE, "560");

    /**
     * The 561 type
     */
    public static final int VALUE_561_TYPE = 44;

    /**
     * The instance of the 561 type
     */
    public static final AuthErrorCode VALUE_561 = new AuthErrorCode(VALUE_561_TYPE, "561");

    /**
     * The 562 type
     */
    public static final int VALUE_562_TYPE = 45;

    /**
     * The instance of the 562 type
     */
    public static final AuthErrorCode VALUE_562 = new AuthErrorCode(VALUE_562_TYPE, "562");

    /**
     * The 563 type
     */
    public static final int VALUE_563_TYPE = 46;

    /**
     * The instance of the 563 type
     */
    public static final AuthErrorCode VALUE_563 = new AuthErrorCode(VALUE_563_TYPE, "563");

    /**
     * The 564 type
     */
    public static final int VALUE_564_TYPE = 47;

    /**
     * The instance of the 564 type
     */
    public static final AuthErrorCode VALUE_564 = new AuthErrorCode(VALUE_564_TYPE, "564");

    /**
     * The 565 type
     */
    public static final int VALUE_565_TYPE = 48;

    /**
     * The instance of the 565 type
     */
    public static final AuthErrorCode VALUE_565 = new AuthErrorCode(VALUE_565_TYPE, "565");

    /**
     * The 566 type
     */
    public static final int VALUE_566_TYPE = 49;

    /**
     * The instance of the 566 type
     */
    public static final AuthErrorCode VALUE_566 = new AuthErrorCode(VALUE_566_TYPE, "566");

    /**
     * The 567 type
     */
    public static final int VALUE_567_TYPE = 50;

    /**
     * The instance of the 567 type
     */
    public static final AuthErrorCode VALUE_567 = new AuthErrorCode(VALUE_567_TYPE, "567");

    /**
     * The 568 type
     */
    public static final int VALUE_568_TYPE = 51;

    /**
     * The instance of the 568 type
     */
    public static final AuthErrorCode VALUE_568 = new AuthErrorCode(VALUE_568_TYPE, "568");

    /**
     * The 569 type
     */
    public static final int VALUE_569_TYPE = 52;

    /**
     * The instance of the 569 type
     */
    public static final AuthErrorCode VALUE_569 = new AuthErrorCode(VALUE_569_TYPE, "569");

    /**
     * The 570 type
     */
    public static final int VALUE_570_TYPE = 53;

    /**
     * The instance of the 570 type
     */
    public static final AuthErrorCode VALUE_570 = new AuthErrorCode(VALUE_570_TYPE, "570");

    /**
     * The 571 type
     */
    public static final int VALUE_571_TYPE = 54;

    /**
     * The instance of the 571 type
     */
    public static final AuthErrorCode VALUE_571 = new AuthErrorCode(VALUE_571_TYPE, "571");

    /**
     * The 572 type
     */
    public static final int VALUE_572_TYPE = 55;

    /**
     * The instance of the 572 type
     */
    public static final AuthErrorCode VALUE_572 = new AuthErrorCode(VALUE_572_TYPE, "572");

    /**
     * The 573 type
     */
    public static final int VALUE_573_TYPE = 56;

    /**
     * The instance of the 573 type
     */
    public static final AuthErrorCode VALUE_573 = new AuthErrorCode(VALUE_573_TYPE, "573");

    /**
     * The 574 type
     */
    public static final int VALUE_574_TYPE = 57;

    /**
     * The instance of the 574 type
     */
    public static final AuthErrorCode VALUE_574 = new AuthErrorCode(VALUE_574_TYPE, "574");

    /**
     * The 575 type
     */
    public static final int VALUE_575_TYPE = 58;

    /**
     * The instance of the 575 type
     */
    public static final AuthErrorCode VALUE_575 = new AuthErrorCode(VALUE_575_TYPE, "575");

    /**
     * The 576 type
     */
    public static final int VALUE_576_TYPE = 59;

    /**
     * The instance of the 576 type
     */
    public static final AuthErrorCode VALUE_576 = new AuthErrorCode(VALUE_576_TYPE, "576");

    /**
     * The 577 type
     */
    public static final int VALUE_577_TYPE = 60;

    /**
     * The instance of the 577 type
     */
    public static final AuthErrorCode VALUE_577 = new AuthErrorCode(VALUE_577_TYPE, "577");

    /**
     * The 578 type
     */
    public static final int VALUE_578_TYPE = 61;

    /**
     * The instance of the 578 type
     */
    public static final AuthErrorCode VALUE_578 = new AuthErrorCode(VALUE_578_TYPE, "578");

    /**
     * The 579 type
     */
    public static final int VALUE_579_TYPE = 62;

    /**
     * The instance of the 579 type
     */
    public static final AuthErrorCode VALUE_579 = new AuthErrorCode(VALUE_579_TYPE, "579");

    /**
     * The 580 type
     */
    public static final int VALUE_580_TYPE = 63;

    /**
     * The instance of the 580 type
     */
    public static final AuthErrorCode VALUE_580 = new AuthErrorCode(VALUE_580_TYPE, "580");

    /**
     * The 581 type
     */
    public static final int VALUE_581_TYPE = 64;

    /**
     * The instance of the 581 type
     */
    public static final AuthErrorCode VALUE_581 = new AuthErrorCode(VALUE_581_TYPE, "581");

    /**
     * The 582 type
     */
    public static final int VALUE_582_TYPE = 65;

    /**
     * The instance of the 582 type
     */
    public static final AuthErrorCode VALUE_582 = new AuthErrorCode(VALUE_582_TYPE, "582");

    /**
     * The 586 type
     */
    public static final int VALUE_586_TYPE = 66;

    /**
     * The instance of the 586 type
     */
    public static final AuthErrorCode VALUE_586 = new AuthErrorCode(VALUE_586_TYPE, "586");

    /**
     * The 587 type
     */
    public static final int VALUE_587_TYPE = 67;

    /**
     * The instance of the 587 type
     */
    public static final AuthErrorCode VALUE_587 = new AuthErrorCode(VALUE_587_TYPE, "587");

    /**
     * The 588 type
     */
    public static final int VALUE_588_TYPE = 68;

    /**
     * The instance of the 588 type
     */
    public static final AuthErrorCode VALUE_588 = new AuthErrorCode(VALUE_588_TYPE, "588");

    /**
     * The 590 type
     */
    public static final int VALUE_590_TYPE = 69;

    /**
     * The instance of the 590 type
     */
    public static final AuthErrorCode VALUE_590 = new AuthErrorCode(VALUE_590_TYPE, "590");

    /**
     * The 710 type
     */
    public static final int VALUE_710_TYPE = 70;

    /**
     * The instance of the 710 type
     */
    public static final AuthErrorCode VALUE_710 = new AuthErrorCode(VALUE_710_TYPE, "710");

    /**
     * The 720 type
     */
    public static final int VALUE_720_TYPE = 71;

    /**
     * The instance of the 720 type
     */
    public static final AuthErrorCode VALUE_720 = new AuthErrorCode(VALUE_720_TYPE, "720");

    /**
     * The 721 type
     */
    public static final int VALUE_721_TYPE = 72;

    /**
     * The instance of the 721 type
     */
    public static final AuthErrorCode VALUE_721 = new AuthErrorCode(VALUE_721_TYPE, "721");

    /**
     * The 730 type
     */
    public static final int VALUE_730_TYPE = 73;

    /**
     * The instance of the 730 type
     */
    public static final AuthErrorCode VALUE_730 = new AuthErrorCode(VALUE_730_TYPE, "730");

    /**
     * The 740 type
     */
    public static final int VALUE_740_TYPE = 74;

    /**
     * The instance of the 740 type
     */
    public static final AuthErrorCode VALUE_740 = new AuthErrorCode(VALUE_740_TYPE, "740");

    /**
     * The 800 type
     */
    public static final int VALUE_800_TYPE = 75;

    /**
     * The instance of the 800 type
     */
    public static final AuthErrorCode VALUE_800 = new AuthErrorCode(VALUE_800_TYPE, "800");

    /**
     * The 810 type
     */
    public static final int VALUE_810_TYPE = 76;

    /**
     * The instance of the 810 type
     */
    public static final AuthErrorCode VALUE_810 = new AuthErrorCode(VALUE_810_TYPE, "810");

    /**
     * The 811 type
     */
    public static final int VALUE_811_TYPE = 77;

    /**
     * The instance of the 811 type
     */
    public static final AuthErrorCode VALUE_811 = new AuthErrorCode(VALUE_811_TYPE, "811");

    /**
     * The 812 type
     */
    public static final int VALUE_812_TYPE = 78;

    /**
     * The instance of the 812 type
     */
    public static final AuthErrorCode VALUE_812 = new AuthErrorCode(VALUE_812_TYPE, "812");

    /**
     * The 820 type
     */
    public static final int VALUE_820_TYPE = 79;

    /**
     * The instance of the 820 type
     */
    public static final AuthErrorCode VALUE_820 = new AuthErrorCode(VALUE_820_TYPE, "820");

    /**
     * The 821 type
     */
    public static final int VALUE_821_TYPE = 80;

    /**
     * The instance of the 821 type
     */
    public static final AuthErrorCode VALUE_821 = new AuthErrorCode(VALUE_821_TYPE, "821");

    /**
     * The 822 type
     */
    public static final int VALUE_822_TYPE = 81;

    /**
     * The instance of the 822 type
     */
    public static final AuthErrorCode VALUE_822 = new AuthErrorCode(VALUE_822_TYPE, "822");

    /**
     * The 901 type
     */
    public static final int VALUE_901_TYPE = 82;

    /**
     * The instance of the 901 type
     */
    public static final AuthErrorCode VALUE_901 = new AuthErrorCode(VALUE_901_TYPE, "901");

    /**
     * The 902 type
     */
    public static final int VALUE_902_TYPE = 83;

    /**
     * The instance of the 902 type
     */
    public static final AuthErrorCode VALUE_902 = new AuthErrorCode(VALUE_902_TYPE, "902");

    /**
     * The 910 type
     */
    public static final int VALUE_910_TYPE = 84;

    /**
     * The instance of the 910 type
     */
    public static final AuthErrorCode VALUE_910 = new AuthErrorCode(VALUE_910_TYPE, "910");

    /**
     * The 911 type
     */
    public static final int VALUE_911_TYPE = 85;

    /**
     * The instance of the 911 type
     */
    public static final AuthErrorCode VALUE_911 = new AuthErrorCode(VALUE_911_TYPE, "911");

    /**
     * The 912 type
     */
    public static final int VALUE_912_TYPE = 86;

    /**
     * The instance of the 912 type
     */
    public static final AuthErrorCode VALUE_912 = new AuthErrorCode(VALUE_912_TYPE, "912");

    /**
     * The 913 type
     */
    public static final int VALUE_913_TYPE = 87;

    /**
     * The instance of the 913 type
     */
    public static final AuthErrorCode VALUE_913 = new AuthErrorCode(VALUE_913_TYPE, "913");

    /**
     * The 930 type
     */
    public static final int VALUE_930_TYPE = 88;

    /**
     * The instance of the 930 type
     */
    public static final AuthErrorCode VALUE_930 = new AuthErrorCode(VALUE_930_TYPE, "930");

    /**
     * The 931 type
     */
    public static final int VALUE_931_TYPE = 89;

    /**
     * The instance of the 931 type
     */
    public static final AuthErrorCode VALUE_931 = new AuthErrorCode(VALUE_931_TYPE, "931");

    /**
     * The 932 type
     */
    public static final int VALUE_932_TYPE = 90;

    /**
     * The instance of the 932 type
     */
    public static final AuthErrorCode VALUE_932 = new AuthErrorCode(VALUE_932_TYPE, "932");

    /**
     * The 933 type
     */
    public static final int VALUE_933_TYPE = 91;

    /**
     * The instance of the 933 type
     */
    public static final AuthErrorCode VALUE_933 = new AuthErrorCode(VALUE_933_TYPE, "933");

    /**
     * The 934 type
     */
    public static final int VALUE_934_TYPE = 92;

    /**
     * The instance of the 934 type
     */
    public static final AuthErrorCode VALUE_934 = new AuthErrorCode(VALUE_934_TYPE, "934");

    /**
     * The 935 type
     */
    public static final int VALUE_935_TYPE = 93;

    /**
     * The instance of the 935 type
     */
    public static final AuthErrorCode VALUE_935 = new AuthErrorCode(VALUE_935_TYPE, "935");

    /**
     * The 936 type
     */
    public static final int VALUE_936_TYPE = 94;

    /**
     * The instance of the 936 type
     */
    public static final AuthErrorCode VALUE_936 = new AuthErrorCode(VALUE_936_TYPE, "936");

    /**
     * The 937 type
     */
    public static final int VALUE_937_TYPE = 95;

    /**
     * The instance of the 937 type
     */
    public static final AuthErrorCode VALUE_937 = new AuthErrorCode(VALUE_937_TYPE, "937");

    /**
     * The 938 type
     */
    public static final int VALUE_938_TYPE = 96;

    /**
     * The instance of the 938 type
     */
    public static final AuthErrorCode VALUE_938 = new AuthErrorCode(VALUE_938_TYPE, "938");

    /**
     * The 939 type
     */
    public static final int VALUE_939_TYPE = 97;

    /**
     * The instance of the 939 type
     */
    public static final AuthErrorCode VALUE_939 = new AuthErrorCode(VALUE_939_TYPE, "939");

    /**
     * The 940 type
     */
    public static final int VALUE_940_TYPE = 98;

    /**
     * The instance of the 940 type
     */
    public static final AuthErrorCode VALUE_940 = new AuthErrorCode(VALUE_940_TYPE, "940");

    /**
     * The 941 type
     */
    public static final int VALUE_941_TYPE = 99;

    /**
     * The instance of the 941 type
     */
    public static final AuthErrorCode VALUE_941 = new AuthErrorCode(VALUE_941_TYPE, "941");

    /**
     * The 950 type
     */
    public static final int VALUE_950_TYPE = 100;

    /**
     * The instance of the 950 type
     */
    public static final AuthErrorCode VALUE_950 = new AuthErrorCode(VALUE_950_TYPE, "950");

    /**
     * The 951 type
     */
    public static final int VALUE_951_TYPE = 101;

    /**
     * The instance of the 951 type
     */
    public static final AuthErrorCode VALUE_951 = new AuthErrorCode(VALUE_951_TYPE, "951");

    /**
     * The 980 type
     */
    public static final int VALUE_980_TYPE = 102;

    /**
     * The instance of the 980 type
     */
    public static final AuthErrorCode VALUE_980 = new AuthErrorCode(VALUE_980_TYPE, "980");

    /**
     * The 995 type
     */
    public static final int VALUE_995_TYPE = 103;

    /**
     * The instance of the 995 type
     */
    public static final AuthErrorCode VALUE_995 = new AuthErrorCode(VALUE_995_TYPE, "995");

    /**
     * The 996 type
     */
    public static final int VALUE_996_TYPE = 104;

    /**
     * The instance of the 996 type
     */
    public static final AuthErrorCode VALUE_996 = new AuthErrorCode(VALUE_996_TYPE, "996");

    /**
     * The 997 type
     */
    public static final int VALUE_997_TYPE = 105;

    /**
     * The instance of the 997 type
     */
    public static final AuthErrorCode VALUE_997 = new AuthErrorCode(VALUE_997_TYPE, "997");

    /**
     * The 998 type
     */
    public static final int VALUE_998_TYPE = 106;

    /**
     * The instance of the 998 type
     */
    public static final AuthErrorCode VALUE_998 = new AuthErrorCode(VALUE_998_TYPE, "998");

    /**
     * The 999 type
     */
    public static final int VALUE_999_TYPE = 107;

    /**
     * The instance of the 999 type
     */
    public static final AuthErrorCode VALUE_999 = new AuthErrorCode(VALUE_999_TYPE, "999");

    /**
     * Field _memberTable
     */
    private static Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private AuthErrorCode(int type, String value)
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- auth_2_0.types.AuthErrorCode(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * AuthErrorCode
     * 
     * @return Enumeration
     */
    public static Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this AuthErrorCode
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("100", VALUE_100);
        members.put("200", VALUE_200);
        members.put("300", VALUE_300);
        members.put("310", VALUE_310);
        members.put("311", VALUE_311);
        members.put("312", VALUE_312);
        members.put("313", VALUE_313);
        members.put("314", VALUE_314);
        members.put("315", VALUE_315);
        members.put("316", VALUE_316);
        members.put("330", VALUE_330);
        members.put("400", VALUE_400);
        members.put("402", VALUE_402);
        members.put("403", VALUE_403);
        members.put("500", VALUE_500);
        members.put("501", VALUE_501);
        members.put("502", VALUE_502);
        members.put("503", VALUE_503);
        members.put("504", VALUE_504);
        members.put("505", VALUE_505);
        members.put("510", VALUE_510);
        members.put("511", VALUE_511);
        members.put("512", VALUE_512);
        members.put("513", VALUE_513);
        members.put("520", VALUE_520);
        members.put("521", VALUE_521);
        members.put("524", VALUE_524);
        members.put("527", VALUE_527);
        members.put("528", VALUE_528);
        members.put("530", VALUE_530);
        members.put("540", VALUE_540);
        members.put("541", VALUE_541);
        members.put("542", VALUE_542);
        members.put("543", VALUE_543);
        members.put("550", VALUE_550);
        members.put("551", VALUE_551);
        members.put("552", VALUE_552);
        members.put("553", VALUE_553);
        members.put("554", VALUE_554);
        members.put("555", VALUE_555);
        members.put("556", VALUE_556);
        members.put("557", VALUE_557);
        members.put("558", VALUE_558);
        members.put("559", VALUE_559);
        members.put("560", VALUE_560);
        members.put("561", VALUE_561);
        members.put("562", VALUE_562);
        members.put("563", VALUE_563);
        members.put("564", VALUE_564);
        members.put("565", VALUE_565);
        members.put("566", VALUE_566);
        members.put("567", VALUE_567);
        members.put("568", VALUE_568);
        members.put("569", VALUE_569);
        members.put("570", VALUE_570);
        members.put("571", VALUE_571);
        members.put("572", VALUE_572);
        members.put("573", VALUE_573);
        members.put("574", VALUE_574);
        members.put("575", VALUE_575);
        members.put("576", VALUE_576);
        members.put("577", VALUE_577);
        members.put("578", VALUE_578);
        members.put("579", VALUE_579);
        members.put("580", VALUE_580);
        members.put("581", VALUE_581);
        members.put("582", VALUE_582);
        members.put("586", VALUE_586);
        members.put("587", VALUE_587);
        members.put("588", VALUE_588);
        members.put("590", VALUE_590);
        members.put("710", VALUE_710);
        members.put("720", VALUE_720);
        members.put("721", VALUE_721);
        members.put("730", VALUE_730);
        members.put("740", VALUE_740);
        members.put("800", VALUE_800);
        members.put("810", VALUE_810);
        members.put("811", VALUE_811);
        members.put("812", VALUE_812);
        members.put("820", VALUE_820);
        members.put("821", VALUE_821);
        members.put("822", VALUE_822);
        members.put("901", VALUE_901);
        members.put("902", VALUE_902);
        members.put("910", VALUE_910);
        members.put("911", VALUE_911);
        members.put("912", VALUE_912);
        members.put("913", VALUE_913);
        members.put("930", VALUE_930);
        members.put("931", VALUE_931);
        members.put("932", VALUE_932);
        members.put("933", VALUE_933);
        members.put("934", VALUE_934);
        members.put("935", VALUE_935);
        members.put("936", VALUE_936);
        members.put("937", VALUE_937);
        members.put("938", VALUE_938);
        members.put("939", VALUE_939);
        members.put("940", VALUE_940);
        members.put("941", VALUE_941);
        members.put("950", VALUE_950);
        members.put("951", VALUE_951);
        members.put("980", VALUE_980);
        members.put("995", VALUE_995);
        members.put("996", VALUE_996);
        members.put("997", VALUE_997);
        members.put("998", VALUE_998);
        members.put("999", VALUE_999);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this AuthErrorCode
     * 
     * @return String
     */
    public String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new AuthErrorCode based on the given String value.
     * 
     * @param string
     * @return AuthErrorCode
     */
    public static auth_2_0.types.AuthErrorCode valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid AuthErrorCode";
            throw new IllegalArgumentException(err);
        }
        return (AuthErrorCode) obj;
    } //-- auth_2_0.types.AuthErrorCode valueOf(java.lang.String) 

}
