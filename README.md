GeoIpRedis
==========

Contain util for loading GeoLiteCity csv database from MaxMind to Redis and library for fast IP lookup. 

Get your GeoIP city CSVs from http://www.maxmind.com/app/geolite.

Why?
Loading the GeoIP databases from disk is slow, and doing that for every request is a pain. Redis keeps your GeoIP database in memory and makes it easy to query.

Total valume memory usage in Redis after loading GeoIp database is 663.73M. Performance is about 2500 IPs per second on DualCore laptop.
