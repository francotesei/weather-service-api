package redbee.challenge.mocks;

/**
 * Created by ftesei on 14/07/17.
 */
public class Mock {

    public static String getMock(){
return "{\n" +
        " \"query\": {\n" +
        "  \"count\": 1,\n" +
        "  \"created\": \"2017-07-14T22:42:21Z\",\n" +
        "  \"lang\": \"en-US\",\n" +
        "  \"diagnostics\": {\n" +
        "   \"publiclyCallable\": \"true\",\n" +
        "   \"url\": [\n" +
        "    {\n" +
        "     \"execution-start-time\": \"1\",\n" +
        "     \"execution-stop-time\": \"2\",\n" +
        "     \"execution-time\": \"1\",\n" +
        "     \"content\": \"http://unifiedgeo.geotech.yahoo.com:4080/geo/v1/geocode?q=nome%2C%20ak&start=0&size=1&optionalfields=woe.ancestors&minconfidence=0.0001\"\n" +
        "    },\n" +
        "    {\n" +
        "     \"execution-start-time\": \"4\",\n" +
        "     \"execution-stop-time\": \"7\",\n" +
        "     \"execution-time\": \"3\",\n" +
        "     \"content\": \"http://weather-ydn-yql.media.yahoo.com:4080/v3/public/weather/rss?w=2460286\"\n" +
        "    }\n" +
        "   ],\n" +
        "   \"javascript\": {\n" +
        "    \"execution-start-time\": \"0\",\n" +
        "    \"execution-stop-time\": \"3\",\n" +
        "    \"execution-time\": \"3\",\n" +
        "    \"instructions-used\": \"16231\",\n" +
        "    \"table-name\": \"geo.places\"\n" +
        "   },\n" +
        "   \"user-time\": \"8\",\n" +
        "   \"service-time\": \"4\",\n" +
        "   \"build-version\": \"2.0.149\"\n" +
        "  },\n" +
        "  \"results\": {\n" +
        "   \"channel\": {\n" +
        "    \"location\": {\n" +
        "     \"city\": \"Nome\",\n" +
        "     \"country\": \"United States\",\n" +
        "     \"region\": \" AK\"\n" +
        "    },\n" +
        "    \"wind\": {\n" +
        "     \"chill\": \"63\",\n" +
        "     \"direction\": \"158\",\n" +
        "     \"speed\": \"7\"\n" +
        "    },\n" +
        "    \"atmosphere\": {\n" +
        "     \"humidity\": \"73\",\n" +
        "     \"pressure\": \"1010.0\",\n" +
        "     \"rising\": \"0\",\n" +
        "     \"visibility\": \"16.1\"\n" +
        "    },\n" +
        "    \"astronomy\": {\n" +
        "     \"sunrise\": \"1:7 am\",\n" +
        "     \"sunset\": \"5:6 am\"\n" +
        "    },\n" +
        "    \"item\": {\n" +
        "     \"title\": \"Conditions for Nome, AK, US at 01:00 PM AKDT\",\n" +
        "     \"lat\": \"64.499474\",\n" +
        "     \"long\": \"-165.405792\",\n" +
        "     \"link\": \"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\",\n" +
        "     \"pubDate\": \"Fri, 14 Jul 2017 01:00 PM AKDT\",\n" +
        "     \"condition\": {\n" +
        "      \"code\": \"31\",\n" +
        "      \"date\": \"Fri, 14 Jul 2017 01:00 PM AKDT\",\n" +
        "      \"temp\": \"62\",\n" +
        "      \"text\": \"Clear\"\n" +
        "     },\n" +
        "     \"forecast\": [\n" +
        "      {\n" +
        "       \"code\": \"12\",\n" +
        "       \"date\": \"14 Jul 2017\",\n" +
        "       \"day\": \"Fri\",\n" +
        "       \"high\": \"63\",\n" +
        "       \"low\": \"51\",\n" +
        "       \"text\": \"Rain\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"26\",\n" +
        "       \"date\": \"15 Jul 2017\",\n" +
        "       \"day\": \"Sat\",\n" +
        "       \"high\": \"56\",\n" +
        "       \"low\": \"51\",\n" +
        "       \"text\": \"Cloudy\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"39\",\n" +
        "       \"date\": \"16 Jul 2017\",\n" +
        "       \"day\": \"Sun\",\n" +
        "       \"high\": \"54\",\n" +
        "       \"low\": \"51\",\n" +
        "       \"text\": \"Scattered Showers\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"39\",\n" +
        "       \"date\": \"17 Jul 2017\",\n" +
        "       \"day\": \"Mon\",\n" +
        "       \"high\": \"54\",\n" +
        "       \"low\": \"52\",\n" +
        "       \"text\": \"Scattered Showers\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"12\",\n" +
        "       \"date\": \"18 Jul 2017\",\n" +
        "       \"day\": \"Tue\",\n" +
        "       \"high\": \"55\",\n" +
        "       \"low\": \"54\",\n" +
        "       \"text\": \"Rain\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"26\",\n" +
        "       \"date\": \"19 Jul 2017\",\n" +
        "       \"day\": \"Wed\",\n" +
        "       \"high\": \"60\",\n" +
        "       \"low\": \"55\",\n" +
        "       \"text\": \"Cloudy\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"28\",\n" +
        "       \"date\": \"20 Jul 2017\",\n" +
        "       \"day\": \"Thu\",\n" +
        "       \"high\": \"63\",\n" +
        "       \"low\": \"56\",\n" +
        "       \"text\": \"Mostly Cloudy\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"28\",\n" +
        "       \"date\": \"21 Jul 2017\",\n" +
        "       \"day\": \"Fri\",\n" +
        "       \"high\": \"61\",\n" +
        "       \"low\": \"57\",\n" +
        "       \"text\": \"Mostly Cloudy\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"26\",\n" +
        "       \"date\": \"22 Jul 2017\",\n" +
        "       \"day\": \"Sat\",\n" +
        "       \"high\": \"56\",\n" +
        "       \"low\": \"49\",\n" +
        "       \"text\": \"Cloudy\"\n" +
        "      },\n" +
        "      {\n" +
        "       \"code\": \"28\",\n" +
        "       \"date\": \"23 Jul 2017\",\n" +
        "       \"day\": \"Sun\",\n" +
        "       \"high\": \"59\",\n" +
        "       \"low\": \"50\",\n" +
        "       \"text\": \"Mostly Cloudy\"\n" +
        "      }\n" +
        "     ],\n" +
        "     \"description\": \"<![CDATA[<img src=\\\"http://l.yimg.com/a/i/us/we/52/31.gif\\\"/>\\n<BR />\\n<b>Current Conditions:</b>\\n<BR />Clear\\n<BR />\\n<BR />\\n<b>Forecast:</b>\\n<BR /> Fri - Rain. High: 63Low: 51\\n<BR /> Sat - Cloudy. High: 56Low: 51\\n<BR /> Sun - Scattered Showers. High: 54Low: 51\\n<BR /> Mon - Scattered Showers. High: 54Low: 52\\n<BR /> Tue - Rain. High: 55Low: 54\\n<BR />\\n<BR />\\n<a href=\\\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\\\">Full Forecast at Yahoo! Weather</a>\\n<BR />\\n<BR />\\n(provided by <a href=\\\"http://www.weather.com\\\" >The Weather Channel</a>)\\n<BR />\\n]]>\",\n" +
        "     \"guid\": {\n" +
        "      \"isPermaLink\": \"false\"\n" +
        "     }\n" +
        "    }\n" +
        "   }\n" +
        "  }\n" +
        " }\n" +
        "}";

    }

}
