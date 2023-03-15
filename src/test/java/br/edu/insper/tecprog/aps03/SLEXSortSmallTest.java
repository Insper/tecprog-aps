package br.edu.insper.tecprog.aps03;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SLEXSortSmallTest {
    
    @Test
    void exemplo1() {
        String A = "re";
        String words[] = {"ere", "rer", "re"};
        String answer[] = {"re", "rer", "ere"};
        
        SLEXSort.sortByA(A, words);

        assertArrayEquals(words, answer);
    }

    @Test
    void exemplo2() {
        String A = "balujemy";
        String words[] = {"bel", "luba", "lej", "bal", "leje"};
        String answer[] = {"bal", "bel", "luba", "lej", "leje"};
        
        SLEXSort.sortByA(A, words);

        assertArrayEquals(words, answer);
    }

    @Test
    void exemploAleatorioPequeno1() {
        String A = "wrtghpo";
        String words[] = {
            "wpwgggprtw",
            "optorggooo",
            "trtrrtgowp",
            "rowortwohw",
            "htohpoorpo",
            "ogtgwophrw",
            "hrggwprggt",
            "rppwwttopw",
            "hhpopgpttr",
            "oorwwhgpwt",
        };
        String answer[] = {
            "wpwgggprtw",
            "rppwwttopw",
            "rowortwohw",
            "trtrrtgowp",
            "hrggwprggt",
            "htohpoorpo",
            "hhpopgpttr",
            "ogtgwophrw",
            "optorggooo",
            "oorwwhgpwt",
        };
        
        SLEXSort.sortByA(A, words);

        assertArrayEquals(words, answer);
    }

    @Test
    void exemploAleatorioPequeno2() {
        String A = "sweqjycbfmlhin";
        String words[] = {
            "whewsfcyqlfcnlw",
            "ichmjcnewynjjlijecjesql",
            "shncjmiiicyyemcbihjyhwlischsylffhfwjcb",
            "mcseffjllijjililicbwjemfhlbielscbceihejyeyj",
            "yqbjnfelhicwlhsywjhhmbswmswhwwjcmjl",
            "qilwlmhciwwqscbhjmnjsewifeffscwjmmqeescihh",
            "ycsbwwhjhlmhhhe",
            "esiqbljeefhbfhf",
            "ljfchwisinfiqbiiwbmfqfncsmmflmqqwmibq",
            "cewjssjhfijsbbclbfshicfhcflhmhilssfhbfjiclie",
            "wsewiyefqnhycellyscqyywwwbfesyemheelmyisybe",
            "mmlljleflelqcqnlihicmqjbbnqnbmqew",
            "lmfnyjjsjnsqcqyflbnjis",
            "bnlfennmsywefnqwbliibsscbclwijqjenbsqjnbwq",
            "fmclbcybils",
            "myflhbqlfqefnwnjcnmhqfiwchfbe",
            "elnnililbmwyiljjm",
            "blnwsmbybljmcnminfyi",
            "wjlbmiysjfllwelibswmhyliwliyelhmfielyley",
            "nlyqbwqlqycjyysscjbseqmcimcenfsnbfqwshjwbmemlm",
            "wwecnijlbimssjyjm",
            "icyfelclneqqjlfbblhcifcljnbw",
            "chjlwslclwjbhnfychqesqcyeefbfewehhshce",
            "yhniqebibemfcycjjm",
            "ynjwmlyfwqejcjicmlscelqywmfwhbbei",
            "jecbebbich",
            "qisicyjfsfmisiifbjjfqyjwcqimqqilcfceqbwlqmjw",
            "qnjjyqehsfiesjblfnljcfsn",
            "jbycysincmblnbsjyhflcymblhnejhqqhnbqfyewffwjyw",
            "yiwhmnsicbhnlwenfjjjqhsq",
            "yfjjiicsmcehwynsnliswsfhcqmnhbjecyebfifiq",
            "miimywssbnjiqymifnfswywbjbjqlcfcqlchjli",
            "lcjblibwmlhhhljyjclchqqhhm",
            "ljwscwhfhihblfyclnnqcemqjcjbhyibeimqwyfwcf",
            "ihiihqeihbchbbjllsfcemjwcynfhjwlfsjymifby",
            "jccnqlwnwceh",
            "fmwfywjiibfcfimjeeswq",
            "mqhlissiljyswibwqsnwjlbclfqmmqswqmhlbsyi",
            "eqjbchmqccniciyyhewy",
            "ecmwqyffqhicswshbfhsjhhlillqwseijclwyfeewcmjnby",
            "swhiieylysysybnieebelllniwllmijqlijcybf",
            "eybcmsmflhsisssbcbbhmcfyqbnlfeylqfjyweihbysjesci",
            "lbeshjlwqyqhyejsyesnqnebfyimcsmbwnnynhffbc",
            "sliwyehenswebcsyjfjblbbyyljycmmqehmmiybfmye",
            "jsmhbbcbnej",
            "clfqlsfwismiwc",
            "qfcmlcsnmy",
            "nssewinsyefnynlqlsm",
            "hhfqyyjljssilmhsjlfsnlcebbsmwlfhlwmm",
            "jeefcljcesqf",
            "bcqeeeqwjhhlmiyqsbcfjfemewmwnbbymnjb",
            "hwlhnyfjjnmmwffqnhnmhbsihwebimyyqmiyecsbq",
            "ejewenmfhyefl",
            "ibchqicyjylysqinlnllchmililejmfnw",
            "jbyefcljifqimhweeshm",
            "yscliiejqbwefiisewmfqifibnemihnebnefyjswqqes",
            "lnhefqsbefqijelfnjbhwjwfssshbbhwqnnjhihilnjjye",
            "qjbmfhbijcyclljjwwflqshjwnfbefscjjsi",
            "illnffnjmsefmbyhqwbwwjbfilfijewslhlsjliiy",
            "ilnwmnsbylbsjmn",
            "mwclmhhechcj",
            "cfwjyqlcjjqijwwj",
            "mjibjhylmswffifhlcjf",
            "cfjsyfqcmqjllqccjhhjlmhsbqs",
            "neijqhfnqmenenc",
            "iqsbnwbibhnccfwnhbmljwmbyclsfbifcnisyc",
            "bcfmbifilqcwlnmqlle",
            "myfqlhwnmnybeiqbjemhjyyjhchhnqfhycbyibqymscy",
            "qehmllesyjyhysnjewjwhn",
            "csiqlfsibmbwnsbwfmyhweqc",
            "qbbjheljljwnlqwllclwyyiwhwceelyhfmnqfwbsqhbbmmcw",
            "hemsbeswnqwfnclnjhhwcbqejwybbimyihnlnshymelfq",
            "wmqehcfhnbhheenyfjlcby",
            "mbyljwbqhsscyjwhhyewsibijileefm",
            "beebbqflefeychlwqiinbncwmsbqwehjwcicsqqsmnflhq",
            "bnlwnwnwmlenyqwbjyqmecqjnmlwbqll",
            "bcqlnmbfqwbeiyiemfhwjbnni",
            "mnqjebshybmeyqeymnewnsnfssqlbhsfcmjsejief",
            "yilchnssbnllcwjl",
            "fylwclwcmmmhfnjhhfybimsjylc",
            "ieembsqejhcjq",
            "cfshqswfyfiefsslsfnfnyebinyjbfcieqqfbnlemshn",
            "yhybmfqhlwqsqwnqysw",
            "lfhqqqnbybfsqjbibcebnjelqiwislqwnimqmqwbfmqwmnf",
            "bnesesqlyfchsbwlwhi",
            "hyhelfhemmcb",
            "mwsnwqlwcmyflmesjniqbhybbycjhsjhwhwhyyenhjlyscw",
            "flnhcchslyfhhfifbwwhfswhmnyylhejwjyfwiqbsjweqjj",
            "jijcmmlhmcseclbbcfnyc",
            "fifjslemnmcw",
            "embcleqjjmywisfyiybjbmswyewfqihlillhmjnh",
            "ecmbjbnsjssne",
            "sbynehcbweifnjjbfcisnnyfey",
            "ecnscyycyjqc",
            "meiyeebyhlqwsqnjnewjjqfbhnwjjfweinnswccshbcffni",
            "lnsmfhiwhbmfjfqilhwsslnnjfiqcjnfmb",
            "jnmsyfqfqwynybf",
            "qysqbhmjbwybnbwjmfqyysjqlnhhnblswciimfnbcbnjn",
            "qilqwcsebsmyjbiffqmcfewmwhl",
            "mcyejcjibcbsjmnwih",
        };

        String answer[] = {
            "swhiieylysysybnieebelllniwllmijqlijcybf",
            "sbynehcbweifnjjbfcisnnyfey",
            "sliwyehenswebcsyjfjblbbyyljycmmqehmmiybfmye",
            "shncjmiiicyyemcbihjyhwlischsylffhfwjcb",
            "wsewiyefqnhycellyscqyywwwbfesyemheelmyisybe",
            "wwecnijlbimssjyjm",
            "wjlbmiysjfllwelibswmhyliwliyelhmfielyley",
            "wmqehcfhnbhheenyfjlcby",
            "whewsfcyqlfcnlw",
            "esiqbljeefhbfhf",
            "eqjbchmqccniciyyhewy",
            "ejewenmfhyefl",
            "eybcmsmflhsisssbcbbhmcfyqbnlfeylqfjyweihbysjesci",
            "ecmwqyffqhicswshbfhsjhhlillqwseijclwyfeewcmjnby",
            "ecmbjbnsjssne",
            "ecnscyycyjqc",
            "embcleqjjmywisfyiybjbmswyewfqihlillhmjnh",
            "elnnililbmwyiljjm",
            "qehmllesyjyhysnjewjwhn",
            "qjbmfhbijcyclljjwwflqshjwnfbefscjjsi",
            "qysqbhmjbwybnbwjmfqyysjqlnhhnblswciimfnbcbnjn",
            "qbbjheljljwnlqwllclwyyiwhwceelyhfmnqfwbsqhbbmmcw",
            "qfcmlcsnmy",
            "qisicyjfsfmisiifbjjfqyjwcqimqqilcfceqbwlqmjw",
            "qilwlmhciwwqscbhjmnjsewifeffscwjmmqeescihh",
            "qilqwcsebsmyjbiffqmcfewmwhl",
            "qnjjyqehsfiesjblfnljcfsn",
            "jsmhbbcbnej",
            "jeefcljcesqf",
            "jecbebbich",
            "jccnqlwnwceh",
            "jbyefcljifqimhweeshm",
            "jbycysincmblnbsjyhflcymblhnejhqqhnbqfyewffwjyw",
            "jijcmmlhmcseclbbcfnyc",
            "jnmsyfqfqwynybf",
            "yscliiejqbwefiisewmfqifibnemihnebnefyjswqqes",
            "yqbjnfelhicwlhsywjhhmbswmswhwwjcmjl",
            "ycsbwwhjhlmhhhe",
            "yfjjiicsmcehwynsnliswsfhcqmnhbjecyebfifiq",
            "yhybmfqhlwqsqwnqysw",
            "yhniqebibemfcycjjm",
            "yiwhmnsicbhnlwenfjjjqhsq",
            "yilchnssbnllcwjl",
            "ynjwmlyfwqejcjicmlscelqywmfwhbbei",
            "csiqlfsibmbwnsbwfmyhweqc",
            "cewjssjhfijsbbclbfshicfhcflhmhilssfhbfjiclie",
            "cfshqswfyfiefsslsfnfnyebinyjbfcieqqfbnlemshn",
            "cfwjyqlcjjqijwwj",
            "cfjsyfqcmqjllqccjhhjlmhsbqs",
            "clfqlsfwismiwc",
            "chjlwslclwjbhnfychqesqcyeefbfewehhshce",
            "beebbqflefeychlwqiinbncwmsbqwehjwcicsqqsmnflhq",
            "bcqeeeqwjhhlmiyqsbcfjfemewmwnbbymnjb",
            "bcqlnmbfqwbeiyiemfhwjbnni",
            "bcfmbifilqcwlnmqlle",
            "blnwsmbybljmcnminfyi",
            "bnesesqlyfchsbwlwhi",
            "bnlwnwnwmlenyqwbjyqmecqjnmlwbqll",
            "bnlfennmsywefnqwbliibsscbclwijqjenbsqjnbwq",
            "fylwclwcmmmhfnjhhfybimsjylc",
            "fmwfywjiibfcfimjeeswq",
            "fmclbcybils",
            "flnhcchslyfhhfifbwwhfswhmnyylhejwjyfwiqbsjweqjj",
            "fifjslemnmcw",
            "mwsnwqlwcmyflmesjniqbhybbycjhsjhwhwhyyenhjlyscw",
            "mwclmhhechcj",
            "meiyeebyhlqwsqnjnewjjqfbhnwjjfweinnswccshbcffni",
            "mqhlissiljyswibwqsnwjlbclfqmmqswqmhlbsyi",
            "mjibjhylmswffifhlcjf",
            "myfqlhwnmnybeiqbjemhjyyjhchhnqfhycbyibqymscy",
            "myflhbqlfqefnwnjcnmhqfiwchfbe",
            "mcseffjllijjililicbwjemfhlbielscbceihejyeyj",
            "mcyejcjibcbsjmnwih",
            "mbyljwbqhsscyjwhhyewsibijileefm",
            "mmlljleflelqcqnlihicmqjbbnqnbmqew",
            "miimywssbnjiqymifnfswywbjbjqlcfcqlchjli",
            "mnqjebshybmeyqeymnewnsnfssqlbhsfcmjsejief",
            "ljwscwhfhihblfyclnnqcemqjcjbhyibeimqwyfwcf",
            "ljfchwisinfiqbiiwbmfqfncsmmflmqqwmibq",
            "lcjblibwmlhhhljyjclchqqhhm",
            "lbeshjlwqyqhyejsyesnqnebfyimcsmbwnnynhffbc",
            "lfhqqqnbybfsqjbibcebnjelqiwislqwnimqmqwbfmqwmnf",
            "lmfnyjjsjnsqcqyflbnjis",
            "lnsmfhiwhbmfjfqilhwsslnnjfiqcjnfmb",
            "lnhefqsbefqijelfnjbhwjwfssshbbhwqnnjhihilnjjye",
            "hwlhnyfjjnmmwffqnhnmhbsihwebimyyqmiyecsbq",
            "hemsbeswnqwfnclnjhhwcbqejwybbimyihnlnshymelfq",
            "hyhelfhemmcb",
            "hhfqyyjljssilmhsjlfsnlcebbsmwlfhlwmm",
            "ieembsqejhcjq",
            "iqsbnwbibhnccfwnhbmljwmbyclsfbifcnisyc",
            "icyfelclneqqjlfbblhcifcljnbw",
            "ichmjcnewynjjlijecjesql",
            "ibchqicyjylysqinlnllchmililejmfnw",
            "illnffnjmsefmbyhqwbwwjbfilfijewslhlsjliiy",
            "ilnwmnsbylbsjmn",
            "ihiihqeihbchbbjllsfcemjwcynfhjwlfsjymifby",
            "nssewinsyefnynlqlsm",
            "neijqhfnqmenenc",
            "nlyqbwqlqycjyysscjbseqmcimcenfsnbfqwshjwbmemlm",
        };
        
        SLEXSort.sortByA(A, words);

        assertArrayEquals(words, answer);
    }


}
