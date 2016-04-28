package weatherUA;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ivan on 28.04.2016.
 */
public class AvarageWeatherByCity {
    private ExecutorService pool = Executors.newFixedThreadPool(10);
    private String city = "Dnipropetrovsk";
    private Future<Float> temprature = pool.submit(new WeatherByCityUA(city));
    private Future<Float> tempratureMax = pool.submit(new MaxWeatherByCityUA(city));
    private Future<Float> tempratureMin = pool.submit(new MinWeatherByCityUA(city));


//    public float avarageWeather(List<String> cities){
    public float avarageWeather(){
        float result = 0f;


        while (!temprature.isDone()&&!tempratureMax.isDone()&&!tempratureMin.isDone()){

            // waiting while thread is complite
        }

        try {
            System.out.println("temprature: "+temprature.get());
            System.out.println("tempratureMax: "+tempratureMax.get());
            System.out.println("tempratureMin: "+tempratureMin.get());
            result = (temprature.get()+tempratureMax.get()+tempratureMin.get())/3;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.isShutdown();


        return result;
    }
}
