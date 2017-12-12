@Grab("com.google.truth:truth:0.37")

import static com.google.common.truth.Truth.*
import java.util.stream.*

def puzzle = "737\t1866\t1565\t1452\t1908\t1874\t232\t1928\t201\t241\t922\t281\t1651\t1740\t1012\t1001\n" +
        "339\t581\t41\t127\t331\t133\t51\t131\t129\t95\t499\t527\t518\t435\t508\t494\n" +
        "1014\t575\t1166\t259\t152\t631\t1152\t1010\t182\t943\t163\t158\t1037\t1108\t1092\t887\n" +
        "56\t491\t409\t1263\t1535\t41\t1431\t1207\t1393\t700\t1133\t53\t131\t466\t202\t62\n" +
        "632\t403\t118\t352\t253\t672\t711\t135\t116\t665\t724\t780\t159\t133\t90\t100\n" +
        "1580\t85\t1786\t1613\t1479\t100\t94\t1856\t546\t76\t1687\t1769\t1284\t1422\t1909\t1548\n" +
        "479\t356\t122\t372\t786\t1853\t979\t116\t530\t123\t1751\t887\t109\t1997\t160\t1960\n" +
        "446\t771\t72\t728\t109\t369\t300\t746\t86\t910\t566\t792\t616\t84\t338\t57\n" +
        "6599\t2182\t200\t2097\t4146\t7155\t7018\t1815\t1173\t4695\t201\t7808\t242\t3627\t222\t7266\n" +
        "1729\t600\t651\t165\t1780\t2160\t626\t1215\t149\t179\t1937\t1423\t156\t129\t634\t458\n" +
        "1378\t121\t146\t437\t1925\t2692\t130\t557\t2374\t2538\t2920\t2791\t156\t317\t139\t541\n" +
        "1631\t176\t1947\t259\t2014\t153\t268\t752\t2255\t347\t227\t2270\t2278\t544\t2379\t349\n" +
        "184\t314\t178\t242\t145\t410\t257\t342\t183\t106\t302\t320\t288\t151\t449\t127\n" +
        "175\t5396\t1852\t4565\t4775\t665\t4227\t171\t4887\t181\t2098\t4408\t2211\t3884\t2482\t158\n" +
        "1717\t3629\t244\t258\t281\t3635\t235\t4148\t3723\t4272\t3589\t4557\t4334\t4145\t3117\t4510\n" +
        "55\t258\t363\t116\t319\t49\t212\t44\t303\t349\t327\t330\t316\t297\t313\t67"

def input = "5\t9\t2\t8\n" +
        "9\t4\t7\t3\n" +
        "3\t8\t6\t5"

def  v = checkSum(input)
assertThat(v).isEqualTo(9)

v = v = checkSum(puzzle)
println "checkSum  -> $v"


def checkSum(speadsheet) {

    return Stream.of(speadsheet.split("\n"))
        .map{r -> diffMinMax(r)}
        .mapToInt{i->i}
        .sum()

}

def diffMinMax( row ) {

    def lst = row.tokenize("\t").collect{c-> Integer.valueOf(c)}

    for (int i = 0; i < lst.size(); i++) {
        int v1 = lst.get(i)
        for (int j = 0; j < lst.size(); j++) {
            if ( i==j) continue
            int v2 = lst.get(j)
            if ( v1 % v2 == 0) return (v1 / v2).intValue()
        }
    }

    return null

}