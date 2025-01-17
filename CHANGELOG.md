# Changelog for Mapbox Maps SDK v10 for Android

Mapbox welcomes participation and contributions from everyone.

# 10.0.0-rc.6 August 11, 2021

**The Mapbox Maps SDK for Android has moved to release candidate status and is now ready for production use.**

## Breaking changes ⚠️
* Update extension function signatures making them easier to use from Java. ([#539](https://github.com/mapbox/mapbox-maps-android/pull/539))
* Rename `mapView#overlay()` to `mapView#mapboxOverlay`. ([#539](https://github.com/mapbox/mapbox-maps-android/pull/539))

## Features ✨ and improvements 🏁
* Support adding 9-patch images to the style. ([#536](https://github.com/mapbox/mapbox-maps-android/pull/536))
* Outdated data for volatile sources gets hidden if cannot be updated due to no Internet connection. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))

## Bug fixes 🐞
* Fix several memory leaks: clean up OnFpsChangeListener on render thread destroy / introduce Snapshotter#destroy method that must be called in Activity#onDestroy ([#546](https://github.com/mapbox/mapbox-maps-android/pull/546))
* Add layer and source check when creating annotations and init them if not initiated before which creates `AnnotationManager` before loading style. ([#549](https://github.com/mapbox/mapbox-maps-android/pull/549))
* Fix error messages returned by `Style#removeStyleSource` method. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))
* Store persistent layer's LayerPosition, so that layer can be re-added to correct position if LayerPosition.above or LayerPosition.at is used. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))

## Dependencies
* Update gl-native to v10.0.0-rc.6 and common to v16.2.0. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))
* Remove turf dependency of location component plugin. ([#551](https://github.com/mapbox/mapbox-maps-android/pull/551))

# 10.0.0-rc.5 July 28, 2021

## Breaking changes ⚠️
* Improve camera API consumption from java programming language by adding `CameraAnimationsUtils` and `getCamera` JvmName annotations. ([#495](https://github.com/mapbox/mapbox-maps-android/pull/495))
* Rename `AttributionView#setOnClickListener` to `setViewOnClickListener` to avoid overloading the Android SDK method. Results in compilation on Android P and above. Adjust codebase to changes in enforced nullability of Android SDK code. ([#497](https://github.com/mapbox/mapbox-maps-android/pull/497))
* Get rid of using reflection when creating plugins which should decrease `MapView` startup time if plugins are enabled. ([#519](https://github.com/mapbox/mapbox-maps-android/pull/519))

## Features ✨ and improvements 🏁
* Add `showLogo` and `showAttributes` config for snapshotter which are defaulted to true. User can now hide logo and attributions in a snapshotter by changing this config ([#496](https://github.com/mapbox/mapbox-maps-android/pull/496))
* Add lifecycle plugin so there is no need to call `onStart`/`onStop`/`onDestroy`/`onLowMemory` methods explicitly, if the appcompact 1.3.0+ is used. ([#485](https://github.com/mapbox/mapbox-maps-android/pull/485))
* Add a minimum Android Auto test app and an optional Android Auto extension that provide convenient extension function to initialise the MapSurface from a Car App Session. ([#488](https://github.com/mapbox/mapbox-maps-android/pull/488))
* Add lint check for lifecycle methods ([#516](https://github.com/mapbox/mapbox-maps-android/pull/516))

## Bug fixes 🐞
* Fix issues with MapView#snapshot methods that could cause black snapshot or ANR in some cases. ([#508](https://github.com/mapbox/mapbox-maps-android/pull/508))

# 10.0.0-rc.4 July 14, 2021

**The Mapbox Maps SDK for Android has moved to release candidate status and is now ready for production use.**

## Features ✨ and improvements 🏁
* Add new param to allow users localize selected layers. ([#461](https://github.com/mapbox/mapbox-maps-android/pull/461))
* Add API to control logging for animation plugin and disable debug logs by default. ([#474](https://github.com/mapbox/mapbox-maps-android/pull/474))
* Introduce option to use continuous rendering for scale bar. Continuous render mode will fix gfxinfo profiling. ([#458](https://github.com/mapbox/mapbox-maps-android/pull/458))
* Add shortest bearing path option for animators. ([#473](https://github.com/mapbox/mapbox-maps-android/pull/473))
* Add modelTranslation support for LocationPuck3D ([#493](https://github.com/mapbox/mapbox-maps-android/pull/493))
* Add default parameters to coordinate conversion functions of MapCameraManagerDelegate#cameraForCoordinates, MapCameraManagerDelegate#cameraForCoordinateBounds and MapCameraManagerDelegate#cameraForGeometry. This overloads the functions to have a more simple API surface for developers to hook into. ([#491](https://github.com/mapbox/mapbox-maps-android/pull/491))
* Support text-writing-mode property for line symbol-placement text labels (#1766)
  Note: This change will bring following changes for CJK text block:
  - For vertical CJK text, all the characters including Latin and Numbers will be vertically placed now. Previously, Latin and Numbers are horizontally placed.
  - For horizontal CJK text, it may have a slight horizontal shift due to the anchor shift.
* Session SKU generation is now available
* Add getSKUTokenIfValid to get a SKU token for a SKU identifier if it exists and is not expired, return empty string if not.
* Allow filtering of log messages by categories.
* Expose isFiltered for checking logging category settings

## Bug fixes 🐞
* Fix flyTo crash when using single-pixel paddings. ([#478](https://github.com/mapbox/mapbox-maps-android/pull/478))
* Fixed regression in map gestures on devices with Android 6 and lower. ([#484](https://github.com/mapbox/mapbox-maps-android/pull/484))
* Fix overwriting sync geojson data with getSourceAs by async. ([#482](https://github.com/mapbox/mapbox-maps-android/pull/482))
* Clean up network listener after http file source gets out of scope
* Fix line-center anchor calculation when the anchor is very near to the line geometry point
* Fix crash when a Feature State API is used with dedicated rendering thread
* Fix threading issues in HTTP file source
* Fix volatile tilesets handling

## Dependencies
* Update gl-native to v10.0.0-rc.5 and common to v16.0.0. ([#487](https://github.com/mapbox/mapbox-maps-android/pull/487))

# 10.0.0-rc.3 June 30, 2021

**The Mapbox Maps SDK for Android has moved to release candidate status and is now ready for production use.**

## Breaking changes ⚠️
* Perform annotation click synchronously and change AnnotationManagerImpl#queryMapForFeatures function to be synchronous. ([#455](https://github.com/mapbox/mapbox-maps-android/pull/455))

## Features ✨ and improvements 🏁
* Introduce static MapboxMap.clearData(resourceOptions: ResourceOptions, callback: AsyncOperationResultCallback) API and MapboxMap#clearData(callback: AsyncOperationResultCallback), Snapshotter#clearData(callback: AsyncOperationResultCallback) APIs. ([#442](https://github.com/mapbox/mapbox-maps-android/pull/442))
* Optimise the Style#getLayer and Style#getSource APIs' performance. ([#449](https://github.com/mapbox/mapbox-maps-android/pull/449))
* MapEvents#MAP_LOADING_ERROR events now include source and tile information where appropriate. New fields would allow developers to understand what source or tile has failed to load and the reason for a failure. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))

## Bug fixes 🐞
* Fix dropping annotation source updates if those were emitted rapidly without handler. ([#441](https://github.com/mapbox/mapbox-maps-android/pull/441))
* Fix raster/v1 terrain tiles fetch failures caused by appending pixel ratio to the URLs when tile size is equal to 512. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))
* Fixed an issue that the LayerPosition is not persisted across the style change, when using persistent layer based annotation plugin and location component plugin. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))
* Disable MapboxTelemetryInitProvider if the telemetry is disabled via app's manifest reducing startup time. ([#442](https://github.com/mapbox/mapbox-maps-android/pull/442))

## Dependencies
* Bump gl-native to v10.0.0-rc.3, common to v14.2.0. ([#442](https://github.com/mapbox/mapbox-maps-android/pull/442))
* Bump telemetry to 8.1.0. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))

# 10.0.0-rc.2 June 23, 2021

## Features ✨ and improvements 🏁
* Introduce experimental `Style#addPersistentLayer`, `Layer#isPersistent`, `Style#addPersistentStyleLayer`, `Style#addPersistentStyleCustomLayer` and `Style#isStyleLayerPersistent` APIs, so that the tagged layer and its associated resources would remain when a style is reloaded. This improves performance of Annotation and Location Component Plugin during the style change. ([#368](https://github.com/mapbox/mapbox-maps-android/pull/368), ([#422](https://github.com/mapbox/mapbox-maps-android/pull/422)))
* Add Localization API to apply languages to the style by provided locale. ([#379](https://github.com/mapbox/mapbox-maps-android/pull/379))
* Reduce unnecessary render cache texture updates by introducing a small delay after zoom has changed.
* Save and read application state on a background thread, to avoid delays (~3-5ms) on the main thread.

## Bug fixes 🐞
* Introduce size check for render cache. ([#425](https://github.com/mapbox/mapbox-maps-android/pull/425))
* Fix memory leak on render destroy. ([#426](https://github.com/mapbox/mapbox-maps-android/pull/426))
* Changes the visibility of jsonObject in annotation to protected, fix ConcurrentModificationException ([#427](https://github.com/mapbox/mapbox-maps-android/pull/427))
* Fix camera deadlock use-case. ([#439](https://github.com/mapbox/mapbox-maps-android/pull/439))
* Tileset descriptor resolving fixes:
  - Operation completes even if the offline manager instance gets out of scope
  - Fixes leaking TilesetResolverObserver instance
  - Fixes possible crash on cancellation of pending style pack download operation
* Fix text rendering when both 'text-rotate' and 'text-offset' are set.
* Fix Android 12 compatibility to support [pending intents mutability](https://developer.android.com/about/versions/12/behavior-changes-12#pending-intent-mutability).

## Dependencies
* Bump gl-native to v10.0.0-rc.2 ([#422](https://github.com/mapbox/mapbox-maps-android/pull/422))
* Bump telemetry to v8.0.0, android core to v5.0.0 ([#423](https://github.com/mapbox/mapbox-maps-android/pull/423))

# 10.0.0-rc.1 June 10, 2021

## Breaking changes ⚠️
* Rename setter for `Light` object from `add` to `set`. This matches API from GL-JS and clarifies there is only 1 Light object. ([#387](https://github.com/mapbox/mapbox-maps-android/pull/387))
* Rename setter for `Terrain` object from `add` to `set`. ([#391](https://github.com/mapbox/mapbox-maps-android/pull/391))
* Remove `CacheManager`. In the following releases, an API to control temporary map data may be provided. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Remove `ResourceOptions::cacheSize` and `DefaultAmbientCacheSize` constant. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Replace `ResourceOptions::cachePath` with `ResourceOptions::dataPath` that accepts a folder in which the map stores offline style packages and temporary map data. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Rename `TileStore::getInstance()` to `TileStore::create()`. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Remove the `MapView#setRenderCache` and `MapSurface#setRenderCache` API and replaced them with experimental `MapboxMap#setRenderCacheOptions` and `MapboxMap#getRenderCacheOptions` APIs. ([#401](https://github.com/mapbox/mapbox-maps-android/pull/401))
* Change the default `ResourceOptions#dataPath` to `${context.filesDir.absolutePath}/.mapbox/map_data/` and the database name from `ambient_cache.db` to `map_data.db`. ([#403](https://github.com/mapbox/mapbox-maps-android/pull/403))

## Features ✨ and improvements 🏁
* The amount of the unique maps tile packs used in the offline regions is capped by the maximum amount equal to 750. The tile region loading is not be performed if it would cause exceeding of the tile pack limit. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))

## Bug fixes 🐞
* Fix a typo in `MapboxMapUtils` jvm name. ([#396](https://github.com/mapbox/mapbox-maps-android/pull/396))
* Fix an issue that vertical text was not positioned correctly if the `text-offset` property was used. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Emit `MapLoadingError` when an empty token is provided for accessing Mapbox data sources. Before the fix, the application may crash if an empty token was provided and map tries to load data from Mapbox data source. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Create folder structure for provided `ResourceOptions#dataPath` when a provided folder doesn't exist. Before the fix, map expected the folder to exist, and in case it didn't, it was difficult to report an error to the application. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Do not emit `MapLoadingError` when an empty URL is set to GeoJSON source. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Avoid packaging `gms-play-services-location` by default as part of the Android SDK. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Fix an issue that causes public resource definitions not generated in public.txt file. ([#404](https://github.com/mapbox/mapbox-maps-android/pull/404))

## Dependencies
* Bump gl-native to v10.0.0-rc.1, common to v14.0.1 ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))

# 10.0.0-beta.21- June 3, 2021
## Breaking changes ⚠️
* Align load style functions for MapboxMap and Snapshotter. ([#371](https://github.com/mapbox/mapbox-maps-android/pull/371))
* Change the default ambient cache path to `.mapbox/maps/ambient_cache.db` ([#373](https://github.com/mapbox/mapbox-maps-android/pull/373))
* Move text-font property from PointAnnotation to PointAnnotationManager ([#375](https://github.com/mapbox/mapbox-maps-android/pull/375))
* Remove CredentialsManager in favour of ResourceOptionsManager ([#365](https://github.com/mapbox/mapbox-maps-android/pull/365))
* Introduce separate minZoom/maxZoom fields into CustomGeometrySourceOptions API instead of the formerly used "zoomRange"

## Features ✨ and improvements 🏁
* Rework setPrefetchZoomDelta to reduce loading of expensive tiles and optimize zoom use-case (#1850)
* Send billing event when Map is loaded 

## Bug fixes 🐞
* Fixed an issue that causes OnStyleLoaded callback not fired when there's a sprite loading error. ([#358](https://github.com/mapbox/mapbox-maps-android/pull/358))
* Update map camera on first animator update. ([#352](https://github.com/mapbox/mapbox-maps-android/pull/352))
* Fix crash due to missing access token ([#365](https://github.com/mapbox/mapbox-maps-android/pull/365))
* Call style loaded callback if data set directly to geojson. ([#377](https://github.com/mapbox/mapbox-maps-android/pull/377))
* Geojson async data parsing: fixes and improvements. ([#380](https://github.com/mapbox/mapbox-maps-android/pull/380))
* Fix terrain transparency issue when a sky layer is not used
* Make style pack resources immutable protecting the style pack from getting out of sync in case the style is updated remotely

## Dependencies
* Bump glNative to 10.0.0-beta.23, common to 13.0.0 ([#362](https://github.com/mapbox/mapbox-maps-android/pull/362))
* Bump mapbox-events-android to latest releases telem-7.0.3 and core-4.0.2 ([#370](https://github.com/mapbox/mapbox-maps-android/pull/370))

# 10.0.0-beta.20 - May 20, 2021
## Breaking changes ⚠️
* Introduce ResourceOptionsManager to configure the default resource options, and removed the xml configuration options for cache path and tile store path. ([#339](https://github.com/mapbox/mapbox-maps-android/pull/339))
* Rename default ambient cache database to mapbox/maps/ambient_cache.db  ([#314](https://github.com/mapbox/mapbox-maps-android/pull/314))
* Remove the usage of asset path from the codebase, as it is not useful in Android Maps SDK. ([#334](https://github.com/mapbox/mapbox-maps-android/pull/334))
* Rename `NetworkConnectivity` to `OfflineSwitch`.
* Remove `TileLoadOptions` from `TileRegionLoadOptions`. `networkRestriction` and `acceptExpired` can now be specified directly in `TileRegionLoadOptions`.
* Add `totalBytes` and `transferredBytes` to TileStoreLoadResult.
* `MapboxMap.setBounds` return type changed from Void to Expected.
* Expose tileset version for sources that use TileJSON metadata.
* ResourceRequest `offline-data` boolean field is replaced with the `source` string field, which whether the response came from network, cache or tile store.
* Remove `Style.getStyleGeoJSONSourceClusterLeaves`, `Style.getStyleGeoJSONSourceClusterExpansionZoom`, `Style.getStyleGeoJSONSourceClusterChildren`. All those can be fully replaced by `MapboxMap.queryFeatureExtensions`.
* Parsing geojson on a worker thread. Using DSL GeoJsonSource builders with the following functions `GeoJsonSource.Builder#feature`, `GeoJsonSource.Builder#featureCollection`, `GeoJsonSource.Builder#geometry` will immediately returns GeoJsonSource with no data set and starts preparing actual data using a worker thread. The data will be set to the GeoJsonSource once parsed. ([#327](https://github.com/mapbox/mapbox-maps-android/pull/327))

## Features ✨ and improvements 🏁
* Add a `cameraOptions(cameraState, builderBlock)` inline method that helps mutate an existing `CameraState` object. ([#317](https://github.com/mapbox/mapbox-maps-android/pull/317))
* Add selected state handling to annotation plugin ([#316](https://github.com/mapbox/mapbox-maps-android/pull/316))
* Add API for disabling vertical/horizontal scroll gestures ([#319](https://github.com/mapbox/mapbox-maps-android/pull/319))
* Introduce API to enable render cache feature that could bring up rendering performance improvement. ([#326](https://github.com/mapbox/mapbox-maps-android/pull/326))
* Add `removeAnnotationManager` API. ([#330](https://github.com/mapbox/mapbox-maps-android/pull/330))
* Improve terrain's rendering performance 
* Set `begin` and `end` timestamps for StyleLoaded and MapLoaded events, so that developers could check how much time it takes to load style and map, respectively
* Added `tile-requests-delay` and `tile-network-requests-delay` runtime source properties - an API for tile requests delay
* Introduce MapOptions.optimizeForTerrain option that allow style rendering optimizations for terrain rendering
* The `text-line-height` is now data-driven property
* MapLoaded, StyleLoaded and StyleDataLoaded events now contain begin and end timestamps reflecting the effective duration timespan
* When line lablels are inside the flip state retaining range (+/- 5 degrees around the vertical direction), the lables' flip state will be kept the same
* Improve rendering quality of fill outlines when using render cache

## Bug fixes 🐞
* Fix scalebar doesn't refresh issue. ([#331](https://github.com/mapbox/mapbox-maps-android/pull/331))
* Trigger nested high-level animator listener correctly. ([#335](https://github.com/mapbox/mapbox-maps-android/pull/335))
* Make compass visible when camera was mutated while compass was disabled. ([#322](https://github.com/mapbox/mapbox-maps-android/pull/322))
* Enable LocationComponent automatically when style loaded; fix null island location puck ([#333](https://github.com/mapbox/mapbox-maps-android/pull/333))
* Fix crash if the belowLayerId doesn't exist on the current style ([#330](https://github.com/mapbox/mapbox-maps-android/pull/330))
* Fixed an issue that style pack download cancels pending tileset descriptor resolving, now tile region loading and style pack loading can work in parallel.
* Fixed the excessive network usage during map browsing caused by losing of the expiration date and the etag for the cached files
* Fix excessive network usage for delayed tile requests
* On style pack update we reset only glyphs and only when the updated options require less glyphs than currently available and we make sure ambient cache size limit is never exceeded
* Emit `StyleDataLoaded` and `SourceDataLoaded` synchronously if possible, so that developers could modify style and sources before map starts rendering style
* Fix occasional Adreno 640 and 620 driver warnings and deadlock when terrain is used
* Fix rendering order of transparent terrain proxy tiles

## Dependencies
* Update telemetry (v7.0.1) and core (v4.0.1) dependencies to latest major version releases ([#337](https://github.com/mapbox/mapbox-maps-android/pull/337))
* Bump gl-native to v10.0.0-beta.22 and common to v12.0.0. ([#338](https://github.com/mapbox/mapbox-maps-android/pull/338))

# 10.0.0-beta.19 - May 5, 2021
## Breaking changes ⚠️
* Remove temporary CustomMapInterface used for testing, obsolete with having interface inheritance from upstream. ([#296](https://github.com/mapbox/mapbox-maps-android/pull/296))
* Align MapCameraManagerDelegate with MapCameraManagerInterface ([#293](https://github.com/mapbox/mapbox-maps-android/pull/293))
* Refactor CameraOptions and change `MapboxMap.getCameraState` method to return non-nullable CameraState record
* Remove `MapboxMap.getMinZoom`, `MapboxMap.getMaxZoom` and `MapboxMap.getScale` methods that are duplicate of functionality provided by `MapboxMap.getBounds`. `MapboxMap.getBounds` returns new CameraBounds type with non-nullable fields.
* Remove `MapboxMap.setDefaultFramebufferObject`.
* Remove `MapboxMap.dumpDebugLog`.
* Remove `isPanning`, `isRotating`, `isScaling` and `cancelTransitions` methods from MapboxMap. Controlling map animations should be done with camera animation plugin.
* Remove following methods from MapCameraManagerDelegate (formerly MapCameraDelegate): getLan(), getLon(), getPitch(), getBearing(), getPadding(), setBearing(double). Those properties could be accessed now from MapCameraManagerDelegate.cameraState directly.

### OfflineManager and CacheManager
* Introduce TileStoreUsageMode enum and use it in resource options. New enum allows to set tile store usage mode in an non ambiguous way.
* Cache manager asynchronous  calls complete even after the cache manager instance gets out of scope on the client side. Fix possible crash on setDatabasePath() call
* CacheManager::prefetchAmbientCache() semantics is updated


## Features ✨ and improvements 🏁
* Add styleUri property in MapInitOptions ([#287](https://github.com/mapbox/mapbox-maps-android/pull/287))
* Refactored plugin system to have more granular control over which plugins are loaded when creating a MapView programmatically. ([#231](https://github.com/mapbox/mapbox-maps-android/pull/231))
* Instrument tests for offline ([#290](https://github.com/mapbox/mapbox-maps-android/pull/290))
* Cleanup kdoc documentation, remove html tags ([#305](https://github.com/mapbox/mapbox-maps-android/pull/305))
* Reduce GPU memory usage by reusing depth stencil buffer for terrain rendering


## Bug fixes 🐞
* Request layout when updating ornaments margins, making updates immediate ([#292](https://github.com/mapbox/mapbox-maps-android/pull/292))
* Remove runtime plugin dependency for legacy location plugin. ([#295](https://github.com/mapbox/mapbox-maps-android/pull/295))
* Fix an issue that causes the extension functions not discoverable from downstream projects. ([#299](https://github.com/mapbox/mapbox-maps-android/pull/299))
* Style and map error loading listeners are only called for the style that was associated to the listeners when style loading started. This avoid calling the wrong listeners with multiple style loads. Renamed Style#isStyleLoadInited to Style#isStyleLoadInitiated. ([#300](https://github.com/mapbox/mapbox-maps-android/pull/300))
* Fix crash if doing setCamera during map loading ([#310](https://github.com/mapbox/mapbox-maps-android/pull/310))
* Fix map rendering issue when `text-field`'s inline images used with complex case expressions
* Fix erroneous font eviction when `text-field`'s formatted sections have `text-font` overrides
* Fix Adreno specific crash that happens when terrain is enabled
* Fix OfflineManager network errors handling
* Fix map rendering issue when feature-state and terrain features are enabled
* The ResourceRequest event response.offline-data field now indicates whether or not the response came from tile store


## Dependencies
* Bump to gl-native v10.0.0-beta.21, update common v11.0.2. ([#304](https://github.com/mapbox/mapbox-maps-android/pull/304))

# 10.0.0-beta.18 - April 22, 2021
## Breaking changes ⚠️
* Rename MapView plugin extension functions. ([#272](https://github.com/mapbox/mapbox-maps-android/pull/272))
  - mapView.getAnnotationPlugin() -> mapView.annotations
  - mapView.getGesturesPlugin() -> mapView.gestures
  - mapView.getOverlayPlugin() -> mapView.overlay() // using function here because of experimental annotation
  - mapView.getLocationComponentPlugin() -> mapView.location
  - mapView.getCameraAnimationsPlugin() -> mapView.camera
  - mapView.getAttributionPlugin() -> mapView.attribution
  - mapView.getCompassPlugin() -> mapView.compass
  - mapView.getLogoPlugin() -> mapView.logo
  - mapView.getScaleBarPlugin() -> mapView.scalebar
* Remove deprecated location plugin ([#276](https://github.com/mapbox/mapbox-maps-android/pull/276))
* Add feature sdk initialisation ([#269](https://github.com/mapbox/mapbox-maps-android/pull/269))
  - Load the Mapbox Street style by default if user doesn't load any style before the onStart lifecycle event.
  - Introduce `CredentialsManager` to manage mapbox access token, when all `MapView`s should use same token could be handled by using `CredentialsManager.shared` static object.
  - Introduce `MapInitOptions` to replace MapboxMapOptions. 
## Features ✨ and improvements 🏁
* High-level animations return cancelable interface ([#262](https://github.com/mapbox/mapbox-maps-android/pull/262))
* Introduce OfflineManager API that manages style packs and produces tileset descriptors for the tile store.
  - By default, users may download up to 250MB of data for offline use without incurring additional charges. This limit is subject to change during the beta.
  - The new API replaces the deprecated OfflineRegionManager API. The OfflineManager API can be used to create offline style packs that contain style data, such as: style definition, sprites, fonts and other resources. Tileset descriptors created by the OfflineManager API are used to create tile packs via TileStore API. Mobile maps SDKs use tile packs for rendering map content. 
* Add offline activity example. ([#259](https://github.com/mapbox/mapbox-maps-android/pull/259))
* Load the Mapbox Street style by default if user doesn't load any style before the onStart lifecycle event([#248](https://github.com/mapbox/mapbox-maps-android/pull/248))

## Bug fixes 🐞
* Keep CompassPlugin enabled/disabled state after other properties update ([#252](https://github.com/mapbox/mapbox-maps-android/pull/252))
* Fix disabling logo in xml. ([#273](https://github.com/mapbox/mapbox-maps-android/pull/273))
* Introduce StyleInterface that include the current display's pixel ratio, and fix Style#addImage to take the correct pixel ratio from display.  ([#228](https://github.com/mapbox/mapbox-maps-android/pull/228))
* Properly reset anchor after some gestures。 ([#279](https://github.com/mapbox/mapbox-maps-android/pull/279))
* Remove animator cancel listeners logic duplicating end listeners logic. ([#280](https://github.com/mapbox/mapbox-maps-android/pull/280))

## Dependencies
* Bump gl-native to v10.0.0-beta.20, common to v11.0.1 ([#261](https://github.com/mapbox/mapbox-maps-android/pull/261))

# 10.0.0-beta.17 - April 14, 2021
## Breaking changes ⚠️
* [Annotation plugin] Rename annotation classes, the rules are as follows and applied for Annotations/Options/Managers ([#227](https://github.com/mapbox/mapbox-maps-android/pull/227))
    - Symbol -> PointAnnotation
    - Circle -> CircleAnnotation
    - Line -> PolylineAnnotation
    - Fill -> PolygonAnnotation
* mapboxMap.queryRenderedFeatures will return a new data class QueriedFeature which will contain additional properties ([#247](https://github.com/mapbox/mapbox-maps-android/pull/247)): 
    - source (id of the source)
    - sourceLayer (id of the source's layer)
    - state (feature's state) 
* Rename Style#isStyleFullyLoaded to Style#isStyleLoaded
* Remove old map#drag API and the AnimationOptions API
* Don't emit MapIdle event when there is gesture and / or user animation in progress
* Make overlay plugin experimental ([#233](https://github.com/mapbox/mapbox-maps-android/pull/233))

## Features ✨ and improvements 🏁
* Introducing NetworkConnectivity API (offline switch). If setting setMapboxStackConnected(false), the Reachability API will report NotReachable, http requests are being blocked and if running, cancelled.
* Added new CameraManager.cameraForCoordinates overload
* Added support for query rendered features for Circle Layer on Terrain
* Enable identical code folding and -lto-O3 optimizations to reduce binary size of native map shared library

## Bug fixes 🐞
* Fix runtime crash if logo / attribution not enabled ([#240](https://github.com/mapbox/mapbox-maps-android/pull/240))
* Fixed a bug that causes map not loading when connected through ethernet.
* Fix distance expression parsing for geometries containing over 20k points
* Fixed holes in the ground for terrain with negative elevation
* Make StyleImageMissing callback a no-op after ImageManager destruction
* Reset unprocessed event queue for destructed renderer
* Fix clipping of fill-extrusions on near plane
* Set 'clusterMaxZoom' to be 'maxZoom-1' when it is not provided
* Fix crash for the case when MapSnapshotter object is destructed from within user provided callback
* Terrain render cache now disabled during property transitions
* Fix missing terrain tiles when camera is on mountain peak
* Black screen not used during loading anymore, prefering platform background
* Emit CameraChanged, SourceAdded(Removed) and StyleImageMissing events synchronously

## Dependencies
* [deps] Bump gl-native to v10.0.0-beta.19, common to v11.0.0 ([#247](https://github.com/mapbox/mapbox-maps-android/pull/247))

# 10.0.0-beta.16 - March 25, 2021

## Breaking changes ⚠️
* Remove ModelLayer and ModelSource API ([#128](https://github.com/mapbox/mapbox-maps-android/pull/128))
* Refactor Event API into new Observers. ([#166](https://github.com/mapbox/mapbox-maps-android/pull/166))
* Bump minSdkVersion of the SDK to 21, and bumped okhttp dependency to v4.9.0. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Rename jumpTo(options: CameraOptions) to setCamera(options: CameraOptions), rename setFreeCameraOptions (options: FreeCameraOptions) to setCamera(options: FreeCameraOptions). ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Rename OnMapLoadingFinishedListener to OnMapLoadedListener. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Introduce OnStyleDataLoadedListener to replace OnStyleLoadingFinishedListener, and introduce OnSourceDataLoadedListener to replace OnSourceChangedListener. So that developers have granular control of style/source loading status. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Introduce coordinateBoundsForCamera() API to replace the getRegion() API. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Remove MapObserver from MapSurface's constructor. ([#200](https://github.com/mapbox/mapbox-maps-android/pull/200))

## Features ✨ and improvements 🏁
* [Annotation plugin] Add symbol cluster support ([#122](https://github.com/mapbox/mapbox-maps-android/pull/122))
* [map] Make public API entry points as MapView and Snapshotter ([#149](https://github.com/mapbox/mapbox-maps-android/pull/149))
* [plugins] Remove PluginRequirementException ([#158](https://github.com/mapbox/mapbox-maps-android/pull/158))
* Use String protocol for passing GeoJSON data  ([#162](https://github.com/mapbox/mapbox-maps-android/pull/162))
* [Annotation plugin] Set default values for annotation option properties to null. ([#173](https://github.com/mapbox/mapbox-maps-android/pull/173))
* [rendering] Schedule non-rendering tasks on Android's scheduler to improve render performance. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* [rendering] Query rendered features now work for fill-extrusions when terrain is enabled. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* [rendering] Improved terrain rendering performance due to reduction of loaded tiles. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* [doc] Change http link to markdown style in doc  ([#187](https://github.com/mapbox/mapbox-maps-android/pull/187))
* [rendering] Differentiate render tasks and non-render tasks ([#192](https://github.com/mapbox/mapbox-maps-android/pull/192))
* [gestures] Introduce platform-driven drag API to move a map ([#201](https://github.com/mapbox/mapbox-maps-android/pull/201))

## Bug fixes 🐞
* [Annotation plugin] Implement MapStyleObserverPlugin to listen style load event to reload layer and source ([#161](https://github.com/mapbox/mapbox-maps-android/pull/161))
* [gestures] Fix crash if zooming for SDK less than 23 ([#171](https://github.com/mapbox/mapbox-maps-android/pull/171))
* Fix an issue that will result in map not rendering on a device with Ethernet connection. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Fix the crash when running maps on the emulator. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Patch scroll gesture with a pitched camera ([#184](https://github.com/mapbox/mapbox-maps-android/pull/184))
* [locationcomponent] Fix jitter animations if interrupting animations ([#185](https://github.com/mapbox/mapbox-maps-android/pull/185))
* [animation] Fix zero duration animators, fix medium-level animators to use only CameraAnimators ([#198](https://github.com/mapbox/mapbox-maps-android/pull/198))
* [animations] Fix interpolation for flyTo ([#202](https://github.com/mapbox/mapbox-maps-android/pull/202))

## Dependencies
* Update minSdkVersion of the SDK to 21, and bumped okhttp dependency to v4.9.0. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Update gl-native to v10.0.0-beta.17, common to v10.0.2 ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))

# 10.0.0-beta.15 - March 5, 2021

## Bugs
* [annotation] Fix text-font issue in annotation plugin. ([#144](https://github.com/mapbox/mapbox-maps-android/pull/144))

## Dependencies
* [gl-native] Update to v10.0.0-beta.16, common to beta.12 ([#137](https://github.com/mapbox/mapbox-maps-android/pull/137))

# 10.0.0-beta.14 - February 24, 2021

## Breaking changes
* [map] Change signature of Map#getElevation from Float to Double [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)
* [map] Fixed text-field strings are now returned as formatted expressions [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)
* [annotation] Rename getAnnotationManger to createAnnotationManager [#105](https://github.com/mapbox/mapbox-maps-android/pull/105)
* [style] GeoJsonSource data property can't be empty [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)

## Features
* [location-component] Add isLocatedAt API to location component plugin [#99](https://github.com/mapbox/mapbox-maps-android/pull/99)
* [snapshot] Introduce interfaces for style events and snapshot result [#124](https://github.com/mapbox/mapbox-maps-android/pull/124)
* [annotation] Process anchor animators correctly [#109](https://github.com/mapbox/mapbox-maps-android/pull/109)
* [annotation] Limit adding style images multiple times for annotations [#118](https://github.com/mapbox/mapbox-maps-android/pull/118)
* [annotation] Add GeoJSONOptions configuration [#79](https://github.com/mapbox/mapbox-maps-android/pull/79)
* [annotation] Show all icons and text from annotation manager by default [#115](https://github.com/mapbox/mapbox-maps-android/pull/115)
* [animation] Add kotlin dsl builder for CameraOptions and java builders for CameraAnimatorOptions and MapAnimationOptions [#90](https://github.com/mapbox/mapbox-maps-android/pull/90)
* [map] Better use of Choreographer inside renderer resulting to smoother map animations [#107](https://github.com/mapbox/mapbox-maps-android/pull/107)
* [gestures] change default interpolator from Decelerate to LinearOutSlowIn [#103](https://github.com/mapbox/mapbox-maps-android/pull/103)

## Bugs
* [compass] Hide the compass on startup when facing north [#116](https://github.com/mapbox/mapbox-maps-android/pull/116)
* [annotation] Change default value of text font for symbols to null [#111](https://github.com/mapbox/mapbox-maps-android/pull/111)
* [map] Remove renderStill from public API [#104](https://github.com/mapbox/mapbox-maps-android/pull/104)
* [style]  Rename reference to style plugin and converting them to style extension [#123](https://github.com/mapbox/mapbox-maps-android/pull/123)
* [annotation] Expose collection of annotations as a List instead of Map [#121](https://github.com/mapbox/mapbox-maps-android/pull/121)
* [camera] Trigger map camera change updates immediately, Fix order of animation callbacks in camera animation plugin [#125](https://github.com/mapbox/mapbox-maps-android/pull/125)

## Dependencies
* [gl-native] update to v10.0.0-beta.15 [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)
* [common] update to v10.0.0-beta.11 [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)

# 10.0.0-beta.13 - February 10, 2021

## Features
* [map] Expose FPS listener [#80](https://github.com/mapbox/mapbox-maps-android/pull/80)
* [annotation] Add convenience color int API [#76](https://github.com/mapbox/mapbox-maps-android/pull/76)
* [annotation] Add convenience bitmap API for symbols [#67](https://github.com/mapbox/mapbox-maps-android/pull/67)
* [annotation] Make getting annotation manager configurable [#47](https://github.com/mapbox/mapbox-maps-android/pull/47)
* [location] Improve the default location provider and improve handling of location updates [#58](https://github.com/mapbox/mapbox-maps-android/pull/58)
* [location] Add OnIndicatorPositionChangedListener and OnIndicatorBearingChangedListener [#56](https://github.com/mapbox/mapbox-maps-android/pull/56)

## Bugs
* [map] allow getSourceAs returning null values, handle cast gracefully [#88](https://github.com/mapbox/mapbox-maps-android/pull/88)
* [animation] remove internal plugin singleton, support multi display maps [#70](https://github.com/mapbox/mapbox-maps-android/pull/70)
* [telemetry] correct versioning of BuildConfig [#65](https://github.com/mapbox/mapbox-maps-android/pull/65)
* [annotation] Fix offset array not working issue [#60](https://github.com/mapbox/mapbox-maps-android/pull/60)
* [plugin] make xml attribute parsers internal [#81](https://github.com/mapbox/mapbox-maps-android/pull/81)

## Dependencies
* [gl-native] update to v10.0.0-beta.14 [#87](https://github.com/mapbox/mapbox-maps-android/pull/87)
* [common] update to v10.0.0-beta.9.1 [#87](https://github.com/mapbox/mapbox-maps-android/pull/87)

# 10.0.0-beta.12 - January 27, 2021

## Announcement

V10 is the latest version of the Mapbox Maps SDK for Android. v10 brings substantial performance improvements, new features like 3D terrain and a more powerful camera, modern technical foundations, and a better developer experience.

To get started with v10, please refer to our [migration guide](https://docs.mapbox.com/android/beta/maps/guides/migrate-to-v10/).

## Known Issues

### Style

* Currently there is no compile-time validation of the Style DSL, exceptions will be thrown in runtime.

### Location

* Location component plugin is still under active development and the interfaces are subject to change.

### 3D Terrain

* 3D Terrain is in an experimental state
* 3D Terrain crashes on specific GPU hardware:
    * Qualcomm Adreno 640

### Other
* Annotation plugin is not feature complete with the old implementation
* Restricting the map to a bounds that includes the antemeridian will result in an invalid jump to the left side of the bounds.
* Known deficiencies with max and min zoom map properties
* An invalid LatLng conversion can occur and produce a native crash
* Native crash when resuming the map in specific situations
* Native crash when performing a camera transition using Map#jumpTo
