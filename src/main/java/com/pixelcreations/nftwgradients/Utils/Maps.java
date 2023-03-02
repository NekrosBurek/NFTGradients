package com.pixelcreations.nftwgradients.Utils;


import java.util.HashMap;

public class Maps {


    HashMap<String, String> gradientMap = new HashMap<>();

    public void updateMap(String uuid, String code){
        if (gradientMap.containsKey(uuid)){
            gradientMap.replace(uuid, code);
        } else {
            gradientMap.put(uuid, code);
        }
    }

    public String getGradientMap(String uuid) {
        if (gradientMap.containsKey(uuid)){
            return gradientMap.get(uuid);
        } else {
            return null;
        }
    }

    private String retrieveMap(String uuid){
        if (gradientMap.containsKey(uuid)){
            return gradientMap.get(uuid);
        } else {
            return "No gradient has been set for this player";
        }
    }
}
