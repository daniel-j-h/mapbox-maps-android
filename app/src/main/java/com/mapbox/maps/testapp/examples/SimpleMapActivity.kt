package com.mapbox.maps.testapp.examples

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.extension.style.layers.properties.generated.TextAnchor
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.mapbox.maps.plugin.gestures.addOnMapClickListener
import com.mapbox.maps.testapp.R
import kotlinx.android.synthetic.main.activity_simple_map.*

/**
 * Example of displaying a map.
 */
class SimpleMapActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_simple_map)
    mapView.getMapboxMap()
      .apply {
        setCamera(
          CameraOptions.Builder().center(Point.fromLngLat(LONGITUDE, LATITUDE)).zoom(9.0).build()
        )
      }

    mapView?.getMapboxMap()?.addOnMapClickListener() { point ->
      val pointAnnotationPluginImpl = mapView.annotations.createPointAnnotationManager(mapView)
      // Create the annotation
      val annotation = pointAnnotationPluginImpl.create(
        PointAnnotationOptions().withDraggable(false)
        .withPoint(point)
        .withTextAnchor(TextAnchor.BOTTOM)
        .withTextColor(Color.BLUE)
        .withTextSize(12.0)
        .withTextField("Please don't crash!"))
      Thread.sleep(1)
      // Update its properties shortly after creation - often causes crash
      annotation.textField = "We're an enterprise customer!"
      annotation.textRotate = Math.random() * 180
      true
    }
  }

  override fun onStart() {
    super.onStart()
    mapView.onStart()
  }

  override fun onStop() {
    super.onStop()
    mapView.onStop()
  }

  override fun onLowMemory() {
    super.onLowMemory()
    mapView.onLowMemory()
  }

  override fun onDestroy() {
    super.onDestroy()
    mapView.onDestroy()
  }

  companion object {
    private const val LATITUDE = 40.0
    private const val LONGITUDE = -74.5
  }
}