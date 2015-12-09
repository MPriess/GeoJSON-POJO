GeoJSON-POJO
==================
Simple POJO implementation of GeoJSON Format Specification 1.0.

Specification: http://geojson.org


What is GeoJSON?
-------
GeoJSON is a format for encoding a variety of geographic data structures. A GeoJSON object may represent a geometry,
a feature, or a collection of features. GeoJSON supports the following geometry types: Point, LineString, Polygon, MultiPoint, MultiLineString, MultiPolygon, and GeometryCollection. Features in GeoJSON contain a geometry object and additional properties, and a feature collection represents a list of features.

Maven
-------
Step 1. Add the JitPack repository to your build file 

```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```

Step 2. Add the dependency to your build file.
```xml
<dependency>
  <groupId>com.github.MPriess</groupId>
  <artifactId>GeoJSON-POJO</artifactId>
  <version>1.0.1</version>
</dependency>
```

Example
-------

Point
------
<img src="http://mpriess.com/images/blog/point.png" />

Linestring
------
<img src="http://mpriess.com/images/blog/linestring.png" />


Polygon
------
<img src="http://mpriess.com/images/blog/polygon.png" />


[![Dependency Status](https://www.versioneye.com/user/projects/50466efa9a9d4a0002001162/badge.png)](https://www.versioneye.com/user/projects/50466efa9a9d4a0002001162)
