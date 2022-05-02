
package com.weatherpojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "time_epoch",
    "time",
    "temp_c",
    "temp_f",
    "is_day",
    "condition",
    "wind_mph",
    "wind_kph",
    "wind_degree",
    "wind_dir",
    "pressure_mb",
    "pressure_in",
    "precip_mm",
    "precip_in",
    "humidity",
    "cloud",
    "feelslike_c",
    "feelslike_f",
    "windchill_c",
    "windchill_f",
    "heatindex_c",
    "heatindex_f",
    "dewpoint_c",
    "dewpoint_f",
    "will_it_rain",
    "chance_of_rain",
    "will_it_snow",
    "chance_of_snow",
    "vis_km",
    "vis_miles",
    "gust_mph",
    "gust_kph",
    "uv"
})
@Generated("jsonschema2pojo")
public class Hour {

    @JsonProperty("time_epoch")
    private Integer timeEpoch;
    @JsonProperty("time")
    private String time;
    @JsonProperty("temp_c")
    private Double tempC;
    @JsonProperty("temp_f")
    private Double tempF;
    @JsonProperty("is_day")
    private Integer isDay;
    @JsonProperty("condition")
    private HourCondition condition;
    @JsonProperty("wind_mph")
    private Double windMph;
    @JsonProperty("wind_kph")
    private Double windKph;
    @JsonProperty("wind_degree")
    private Integer windDegree;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("pressure_mb")
    private Double pressureMb;
    @JsonProperty("pressure_in")
    private Double pressureIn;
    @JsonProperty("precip_mm")
    private Double precipMm;
    @JsonProperty("precip_in")
    private Double precipIn;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("cloud")
    private Integer cloud;
    @JsonProperty("feelslike_c")
    private Double feelslikeC;
    @JsonProperty("feelslike_f")
    private Double feelslikeF;
    @JsonProperty("windchill_c")
    private Double windchillC;
    @JsonProperty("windchill_f")
    private Double windchillF;
    @JsonProperty("heatindex_c")
    private Double heatindexC;
    @JsonProperty("heatindex_f")
    private Double heatindexF;
    @JsonProperty("dewpoint_c")
    private Double dewpointC;
    @JsonProperty("dewpoint_f")
    private Double dewpointF;
    @JsonProperty("will_it_rain")
    private Integer willItRain;
    @JsonProperty("chance_of_rain")
    private Integer chanceOfRain;
    @JsonProperty("will_it_snow")
    private Integer willItSnow;
    @JsonProperty("chance_of_snow")
    private Integer chanceOfSnow;
    @JsonProperty("vis_km")
    private Double visKm;
    @JsonProperty("vis_miles")
    private Double visMiles;
    @JsonProperty("gust_mph")
    private Double gustMph;
    @JsonProperty("gust_kph")
    private Double gustKph;
    @JsonProperty("uv")
    private Double uv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("time_epoch")
    public Integer getTimeEpoch() {
        return timeEpoch;
    }

    @JsonProperty("time_epoch")
    public void setTimeEpoch(Integer timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("temp_c")
    public Double getTempC() {
        return tempC;
    }

    @JsonProperty("temp_c")
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    @JsonProperty("temp_f")
    public Double getTempF() {
        return tempF;
    }

    @JsonProperty("temp_f")
    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    @JsonProperty("is_day")
    public Integer getIsDay() {
        return isDay;
    }

    @JsonProperty("is_day")
    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    @JsonProperty("condition")
    public HourCondition getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(HourCondition condition) {
        this.condition = condition;
    }

    @JsonProperty("wind_mph")
    public Double getWindMph() {
        return windMph;
    }

    @JsonProperty("wind_mph")
    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

    @JsonProperty("wind_kph")
    public Double getWindKph() {
        return windKph;
    }

    @JsonProperty("wind_kph")
    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    @JsonProperty("wind_degree")
    public Integer getWindDegree() {
        return windDegree;
    }

    @JsonProperty("wind_degree")
    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    @JsonProperty("wind_dir")
    public String getWindDir() {
        return windDir;
    }

    @JsonProperty("wind_dir")
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    @JsonProperty("pressure_mb")
    public Double getPressureMb() {
        return pressureMb;
    }

    @JsonProperty("pressure_mb")
    public void setPressureMb(Double pressureMb) {
        this.pressureMb = pressureMb;
    }

    @JsonProperty("pressure_in")
    public Double getPressureIn() {
        return pressureIn;
    }

    @JsonProperty("pressure_in")
    public void setPressureIn(Double pressureIn) {
        this.pressureIn = pressureIn;
    }

    @JsonProperty("precip_mm")
    public Double getPrecipMm() {
        return precipMm;
    }

    @JsonProperty("precip_mm")
    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    @JsonProperty("precip_in")
    public Double getPrecipIn() {
        return precipIn;
    }

    @JsonProperty("precip_in")
    public void setPrecipIn(Double precipIn) {
        this.precipIn = precipIn;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("cloud")
    public Integer getCloud() {
        return cloud;
    }

    @JsonProperty("cloud")
    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    @JsonProperty("feelslike_c")
    public Double getFeelslikeC() {
        return feelslikeC;
    }

    @JsonProperty("feelslike_c")
    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    @JsonProperty("feelslike_f")
    public Double getFeelslikeF() {
        return feelslikeF;
    }

    @JsonProperty("feelslike_f")
    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    @JsonProperty("windchill_c")
    public Double getWindchillC() {
        return windchillC;
    }

    @JsonProperty("windchill_c")
    public void setWindchillC(Double windchillC) {
        this.windchillC = windchillC;
    }

    @JsonProperty("windchill_f")
    public Double getWindchillF() {
        return windchillF;
    }

    @JsonProperty("windchill_f")
    public void setWindchillF(Double windchillF) {
        this.windchillF = windchillF;
    }

    @JsonProperty("heatindex_c")
    public Double getHeatindexC() {
        return heatindexC;
    }

    @JsonProperty("heatindex_c")
    public void setHeatindexC(Double heatindexC) {
        this.heatindexC = heatindexC;
    }

    @JsonProperty("heatindex_f")
    public Double getHeatindexF() {
        return heatindexF;
    }

    @JsonProperty("heatindex_f")
    public void setHeatindexF(Double heatindexF) {
        this.heatindexF = heatindexF;
    }

    @JsonProperty("dewpoint_c")
    public Double getDewpointC() {
        return dewpointC;
    }

    @JsonProperty("dewpoint_c")
    public void setDewpointC(Double dewpointC) {
        this.dewpointC = dewpointC;
    }

    @JsonProperty("dewpoint_f")
    public Double getDewpointF() {
        return dewpointF;
    }

    @JsonProperty("dewpoint_f")
    public void setDewpointF(Double dewpointF) {
        this.dewpointF = dewpointF;
    }

    @JsonProperty("will_it_rain")
    public Integer getWillItRain() {
        return willItRain;
    }

    @JsonProperty("will_it_rain")
    public void setWillItRain(Integer willItRain) {
        this.willItRain = willItRain;
    }

    @JsonProperty("chance_of_rain")
    public Integer getChanceOfRain() {
        return chanceOfRain;
    }

    @JsonProperty("chance_of_rain")
    public void setChanceOfRain(Integer chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    @JsonProperty("will_it_snow")
    public Integer getWillItSnow() {
        return willItSnow;
    }

    @JsonProperty("will_it_snow")
    public void setWillItSnow(Integer willItSnow) {
        this.willItSnow = willItSnow;
    }

    @JsonProperty("chance_of_snow")
    public Integer getChanceOfSnow() {
        return chanceOfSnow;
    }

    @JsonProperty("chance_of_snow")
    public void setChanceOfSnow(Integer chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
    }

    @JsonProperty("vis_km")
    public Double getVisKm() {
        return visKm;
    }

    @JsonProperty("vis_km")
    public void setVisKm(Double visKm) {
        this.visKm = visKm;
    }

    @JsonProperty("vis_miles")
    public Double getVisMiles() {
        return visMiles;
    }

    @JsonProperty("vis_miles")
    public void setVisMiles(Double visMiles) {
        this.visMiles = visMiles;
    }

    @JsonProperty("gust_mph")
    public Double getGustMph() {
        return gustMph;
    }

    @JsonProperty("gust_mph")
    public void setGustMph(Double gustMph) {
        this.gustMph = gustMph;
    }

    @JsonProperty("gust_kph")
    public Double getGustKph() {
        return gustKph;
    }

    @JsonProperty("gust_kph")
    public void setGustKph(Double gustKph) {
        this.gustKph = gustKph;
    }

    @JsonProperty("uv")
    public Double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(Double uv) {
        this.uv = uv;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
