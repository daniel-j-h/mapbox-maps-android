package com.mapbox.maps.testapp.examples.style

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.expressions.generated.Expression.Companion.get
import com.mapbox.maps.extension.style.layers.generated.lineLayer
import com.mapbox.maps.extension.style.sources.generated.geoJsonSource
import com.mapbox.maps.extension.style.style
import com.mapbox.maps.testapp.R
import kotlinx.android.synthetic.main.activity_add_marker_symbol.*

/**
 * Example to showcase styling a LineLayer
 */
class LineLayerActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_simple_map)
    mapView.getMapboxMap().also {
      it.setCamera(
        CameraOptions.Builder()
          .center(Point.fromLngLat( 4.0182, 51.1113))
          .zoom(9.0)
          .build()
      )
    }.loadStyle(style(Style.MAPBOX_STREETS) {
      // prepare blue marker from resources
      +geoJsonSource(SOURCE_ID) {
        featureCollection(
          FeatureCollection.fromJson(GEOJSON)
        )
      }
      +lineLayer(LAYER_ID, SOURCE_ID) {
        lineWidth(5.0)
        lineColor(Color.RED)
        lineBlur(get("blur"))
      }
    })
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
    private const val SOURCE_ID = "source_id"
    private const val LAYER_ID = "layer_id"
    private const val GEOJSON = """
{
  "type": "FeatureCollection",
  "features": [
    {
      "type": "Feature",
      "properties": {
        "blur" : 0
      },
      "geometry": {
        "type": "LineString",
        "coordinates": [
          [
            4.40277099609375,
            51.22236764552972
          ],
          [
            4.35333251953125,
            50.84237020615854
          ],
          [
            5.328369140625,
            50.93420001306366
          ],
          [
            5.701904296875,
            50.84930707388861
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
         "blur" : 3
      },
      "geometry": {
        "type": "LineString",
        "coordinates": [
          [
            3.2107543945312496,
            51.212045390353026
          ],
          [
            3.2409667968749996,
            50.80940599750376
          ],
          [
            3.7243652343749996,
            51.05520733858494
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "properties": {
          "blur" : 1
      },
      "geometry": {
        "type": "LineString",
        "coordinates": [
          [
            3.92486572265625,
            50.45225789225832
          ],
          [
            4.864196777343749,
            50.466246274560476
          ],
          [
            5.5865478515625,
            50.649460483096135
          ]
        ]
      }
    }
  ]
}
"""
  }


}