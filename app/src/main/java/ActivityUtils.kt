import android.app.Activity
import com.tiago.tflcodingchallenge.TflApplication
import com.tiago.tflcodingchallenge.di.ApplicationComponent

val Activity.injector: ApplicationComponent get() = (application as TflApplication).appComponent
