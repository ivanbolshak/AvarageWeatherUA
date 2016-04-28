package weatherUA;

import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;

import java.util.concurrent.Callable;

/**
 * Created by Ivan on 28.04.2016.
 */
public class WeatherByCityUA implements Callable<Float> {
    private String city;
    private String country;
    private float result;
    private float celsiy =  273.15f;

    public WeatherByCityUA(String city) {
        this.city = city;
        this.country = "UA";
    }

    public Float call() throws Exception {

        OwmClient owm = new OwmClient();
        WeatherStatusResponse currentWeather = owm.currentWeatherAtCity(city, country);

        if (currentWeather.hasWeatherStatus()){
            WeatherData weather = currentWeather.getWeatherStatus().get(0);
            result = weather.getMain().getTemp();

        }

        return (result-celsiy);
    }
}
