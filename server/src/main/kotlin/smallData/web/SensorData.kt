package smallData.web

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.lang.reflect.Type
import java.security.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KType

/**
 * Created by P on 17.09.2016.
 */
@Component
@RequestMapping("/sensor")
class SensorManager{

    enum class SensorType(val description: String ,val stateOnIcon : String, val stateOffIcon : String)  {
        BRIGHTNESS("brightness","lightbulb-outline","lightbulb"),
        MOVEMENT("movement","walk","human-male")
    }

    data class Sensor(val location : String,val type : SensorType,val dataHistory : MutableList<SensorData>)

    open class SensorData(val value : Boolean,val timestamp : LocalDateTime)
    class TimestampedSensorData(val value: Boolean, val timestamp: LocalDateTime)

    val bedroomBrightness = Sensor("bedroom",SensorType.BRIGHTNESS, mutableListOf())
    val bedroomMovement = Sensor("bedroom",SensorType.MOVEMENT, mutableListOf())
    val livingroomBrightness = Sensor("livingroom",SensorType.BRIGHTNESS, mutableListOf())
    val livingroomMovement = Sensor("livingroom",SensorType.MOVEMENT, mutableListOf())

    val sensordata = ArrayList<Sensor>()

    fun initializeWithDummyData(){
        val rng = Random(1337)

        var nValues = 20

        for (i in 0..nValues){
            bedroomBrightness.dataHistory.add(SensorData(false, LocalDateTime.now().minusDays( rng.nextInt(255).toLong()).minusHours(rng.nextInt(255).toLong())))
            bedroomMovement.dataHistory.add(SensorData(false, LocalDateTime.now().minusDays( rng.nextInt(255).toLong()).minusHours(rng.nextInt(255).toLong())))
            livingroomBrightness.dataHistory.add(SensorData(false, LocalDateTime.now().minusDays( rng.nextInt(255).toLong()).minusHours(rng.nextInt(255).toLong())))
            livingroomMovement.dataHistory.add(SensorData(false, LocalDateTime.now().minusDays( rng.nextInt(255).toLong()).minusHours(rng.nextInt(255).toLong())))

        }
        sensordata.addAll(listOf(bedroomBrightness,bedroomMovement,livingroomBrightness,livingroomMovement))

    }







}





