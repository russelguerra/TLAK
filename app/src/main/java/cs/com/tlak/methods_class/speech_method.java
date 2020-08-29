package cs.com.tlak.methods_class;

public class speech_method {
    private static final String TAG = "speech_method";

    public static boolean speech(String text, String speech) {
        boolean is_true = false;

        if (text.equals(speech))
            is_true = true;

        if (text.equals("ma") && speech.equals("my"))
            is_true = true;

        if (text.equals("ta") && speech.equals("pa"))
            is_true = true;

        if (text.equals("bao") && speech.equals("baho"))
            is_true = true;

        if (text.equals("aba") && speech.equals("abba"))
            is_true = true;

        if (text.equals("ada") && speech.equals("adda"))
            is_true = true;

        if (text.equals("babasa ang babae") && (speech.equals("mabasa ang babae") || speech.equals("labasan ang babae")))
            is_true = true;

        if (text.equals("ang bao ay basa") && speech.equals("ang baho ay basa"))
            is_true = true;

        if (text.equals("may saba ang babae") && (speech.equals("my saba ang babae") || speech.equals("my sa ba ang babae")))
            is_true = true;

        if (text.equals("may saba sa ibaba") && (speech.equals("masaba sa ibaba") || speech.equals("my saba sa ibaba") || speech.equals("may sa ba sa ibaba") || speech.equals("may taba sa ibaba") || speech.equals("my taba sa ibaba")))
            is_true = true;

        if (text.equals("basa ang bao sa ibaba") && speech.equals("basa ang baho sa ibaba"))
            is_true = true;

        if (text.equals("ang saba") && speech.equals("ang taba"))
            is_true = true;

        if (text.equals("iba-iba ang saba sa ibaba") && speech.equals("iba-iba ang taba sa ibaba"))
            is_true = true;

        if (text.equals("ya") && speech.equals("yeah"))
            is_true = true;

        if (text.equals("ra") && (speech.equals("ro") || (speech.contains(text) || speech.equals("la"))))
            is_true = true;

        if (text.equals("da") && speech.equals("the"))
            is_true = true;

        if (text.equals("ada") && speech.equals("adda"))
            is_true = true;

        if (text.equals("ida") && (speech.equals("eda") || speech.equals("either")))
            is_true = true;

        if (text.equals("eda") && speech.equals("ada"))
            is_true = true;

        if (text.equals("daya") && speech.equals("diet"))
            is_true = true;

        if (text.equals("pasada") && speech.equals("lazada"))
            is_true = true;

        if (text.equals("nga") && speech.equals("na"))
            is_true = true;

        if (text.equals("namasada ang ama") && speech.equals("namamasada ang ama"))
            is_true = true;

        if (text.equals("may parada") && speech.equals("my parada"))
            is_true = true;

        if (text.equals("may sagala sa parada") && speech.equals("my sagala sa parada"))
            is_true = true;

        if (text.equals("may parada mamaya") && speech.equals("my parada mamaya"))
            is_true = true;

        if (text.equals("ilaga") && speech.equals("hilaga"))
            is_true = true;

        if (text.equals("gana") && speech.equals("ghana"))
            is_true = true;

        if (text.equals("gagala") && speech.equals("yagala"))
            is_true = true;

        if (text.equals("uuga-uga ang sagala") && speech.equals("uga uga ang sagala"))
            is_true = true;

        if (text.equals("may sagala sa naga") && speech.equals("my sagala sa naga"))
            is_true = true;

        if (text.equals("iha") && speech.equals("hija"))
            is_true = true;

        if (text.equals("uha") && speech.equals("oh ha"))
            is_true = true;

        if (text.equals("kaha") && speech.equals("kaja"))
            is_true = true;

        if (text.equals("ang hasa-hasa") && speech.equals("ang hasa hasa"))
            is_true = true;

        if (text.equals("mahaba ang kaha sa parada") && speech.equals("mahaba ang ka ha sa parada"))
            is_true = true;

        if (text.equals("may dala na hasa-hasa ang ina") && (speech.equals("may dala na hasa hasa ang ina") || speech.equals("my dala na hasa hasa ang ina")))
            is_true = true;

        if (text.equals("masaya ang ina sa dala na hasa-hasa") && speech.equals("masaya ang ina sa dala na hasa hasa"))
            is_true = true;

        if (text.equals("ilalaga ng ina ang hasa-hasa") && (speech.equals("ilalagay ng ina ang hasa hasa") || speech.equals("nilalaga ng ina ang hasa hasa")))
            is_true = true;

        if (text.equals("kama") && speech.equals("comma"))
            is_true = true;

        if (text.equals("oka") && (speech.equals("aka") || speech.equals("ok") || speech.contains("ocha")))
            is_true = true;

        if (text.equals("isaka") && speech.equals("isaca"))
            is_true = true;

        if (text.equals("uuka-uka ang kama") && (speech.equals("uka uka ang ,") || speech.equals("uka uka ang kama")))
            is_true = true;

        if (text.equals("abaka") && speech.equals("abaca"))
            is_true = true;

        if (text.equals("may abaka ang kaka") && speech.equals("my abaca ang kaka"))
            is_true = true;

        if (text.equals("iika-ika ang baka ng makata") && speech.equals("iika ika ang baka ng makata"))
            is_true = true;

        if (text.equals("ela") && speech.equals("ella"))
            is_true = true;

        if (text.equals("ala") && speech.equals("allah") || speech.equals("hala"))
            is_true = true;

        if (text.equals("ula") && speech.equals("hula") || speech.equals("hola"))
            is_true = true;

        if (text.equals("may kalabasa si ela") && (speech.equals("may kalabasa si ella") || speech.equals("my kalabasa si ella")))
            is_true = true;

        if (text.equals("ang kalabasa ay malasa") && speech.equals("ang kalabasa ay malas sa"))
            is_true = true;

        if (text.equals("ema") && speech.equals("emma"))
            is_true = true;

        if (text.equals("oma") && speech.contains("oma"))
            is_true = true;

        if (text.equals("may baka ang makata") && speech.contains("my baka ang makata"))
            is_true = true;

        if (text.equals("may kapa ang mama sa papaya") && speech.contains("my kapa ang mama sa papaya"))
            is_true = true;

        if (text.equals("may papaya ang mama") && speech.contains("my papaya ang mama"))
            is_true = true;

        if (text.equals("may pasa ang papaya") && speech.contains("my pasa ang papaya"))
            is_true = true;

        if (text.equals("si ama ang mama") && (speech.equals("siama ang mama") || speech.equals("siomai ang mama")))
            is_true = true;

        if (text.equals("ang ama ay si uma") && speech.equals("ang ama ay si puma"))
            is_true = true;

        if (text.equals("ana") && speech.equals("anna") || speech.equals("hannah"))
            is_true = true;

        if (text.equals("may banaba ang yaya") && (speech.equals("my banaba ang yaya") || speech.equals("bye-bye na ba ang yaya")))
            is_true = true;

        if (text.equals("ang mana ni ana ay lana") && (speech.equals("ang mana niana alana") || speech.equals("ang mana niana elena") || speech.equals("pamana ni anna elena")))
            is_true = true;

        if (text.equals("nasa balana ang nata") && speech.equals("nasa balana ang nota"))
            is_true = true;

        if (text.equals("masaya si ana sa mana sa ina") && speech.equals("masaya si anna sa mana sa ina"))
            is_true = true;

        if (text.equals("may mana sa ina si ana") && (speech.equals("my mana sa ina si anna") || speech.equals("bye-bye na ba ang yaya")))
            is_true = true;

        if (text.equals("unga") && (speech.equals("oo nga") || speech.contains("unga")))
            is_true = true;

        if (text.equals("nangapa") && speech.equals("nangangapa"))
            is_true = true;

        if (text.equals("nganga") && (speech.equals("na nga") || speech.equals("mga")))
            is_true = true;

        if (text.equals("ngala-ngala") && speech.equals("ngala ngala"))
            is_true = true;

        if (text.equals("uunga-unga") && speech.equals("oo nga oo nga"))
            is_true = true;

        if (text.equals("uunga-unga ang baka") && speech.equals("oo nga oo nga ang baka"))
            is_true = true;

        if (text.equals("sara") && speech.equals("sarah"))
            is_true = true;

        if (text.equals("ragasa") && (speech.equals("regatta") || speech.equals("pagasa")))
            is_true = true;

        if (text.equals("tara na sa kabana") && (speech.equals("tara na sa cabana") || speech.equals("tara na sa kaba na") || speech.equals("tara na sa ka ba na")))
            is_true = true;

        if (text.equals("aba panaya pala ang palara ni ara") && speech.equals("aba panay a pala ang palara ni ara"))
            is_true = true;

        if (text.equals("kay isa ang usa") && (speech.equals("kaisa ang usa") || speech.equals("kai isa ang usa")))
            is_true = true;

        if (text.equals("may usa si isa") && speech.equals("my usa si isa"))
            is_true = true;

        if (text.equals("may tasa sa ibaba") && (speech.equals("may pasa sa ibaba") || speech.equals("my pasa sa ibaba") || speech.equals("my tasa sa ibaba")))
            is_true = true;

        if (text.equals("tama si ama may tasa ang bata") && (speech.equals("tama sa ama may tasa ang bata") || speech.equals("tama sa ama my tasa ang bata") | speech.equals("tama sa ama my pasa ang bata")))
            is_true = true;

        if (text.equals("mahahawa si wada ng kakatawa") && speech.equals("mahahawa hiwaga ng kakatawa"))
            is_true = true;

        if (text.equals("may sawa sa kawa") && speech.equals("my sawa sa kawa"))
            is_true = true;

        if (text.equals("aba oo nga dalawa ang sawa sa kawa") && speech.equals("taba ko nga dalawa ang sawa sa kawa"))
            is_true = true;

        if (text.equals("taya si aya kaya siya ay masaya") && speech.equals("kaya siya kaya siya ay masaya"))
            is_true = true;

        if (text.equals("ang ipa ay nasa kapa") && (speech.equals("ang iba ay nasa papa") || speech.equals("ipa ay nasa papa") || speech.equals("ang ipa ay nasa kaba") || speech.equals("ang iba ay nasa ka pa")))
            is_true = true;

        return is_true;
    }
}
