package apis;

import utils.APIUtils;
import utils.PropertiesUtils;

import java.util.HashMap;
import java.util.Map;

public class ApiParams extends APIUtils {

    PropertiesUtils propertiesUtils = new PropertiesUtils();
    Map<String, String> params = new HashMap<>();

    public Map<String, String> CorreiosParams(String token) {
        params.put("StrRetorno", "xml");
        params.put("nCdServico", "04510");
        params.put("sCepOrigem", "74371520");
        params.put("sCepDestino", "13175613");
        params.put("nVlPeso", "1.00");
        params.put("nVlComprimento", "36.00");
        params.put("nVlALtura", "18.00");
        params.put("nVlLargura", "12.00");
        return params;
    }


    public Map<String, String> CorreiosParams() {
        params.put("StrRetorno", "xml");
        params.put("nCdServico", "04510");
        params.put("sCepOrigem", "74371520");
        params.put("sCepDestino", "13175613");
        params.put("nVlPeso", "1.00");
        params.put("nVlComprimento", "36.00");
        params.put("nVlALtura", "18.00");
        params.put("nVlLargura", "12.00");
        return params;
    }

    public Map<String, String> setParams(Map<String, String> map) {
        params.clear();
        params.put("StrRetorno", "xml");
        params.put("nCdServico", "04510");

        map.entrySet().stream().forEach(e -> params.put(e.getKey(), e.getValue()));
        return params;
    }
}
