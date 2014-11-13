MergeMultipleArrays
===================

Optimizing the total number of moves to merge arrays from data points transmitted from multiple satellites

**Problem.** A series of satellites transmits data points represented as an array on a near-real-time basis. The satellites report their data at approximately the same time and must be merged into a single array, sorted by longitude. They all report within a few seconds or even milliseconds of each other, but the order is unpredictable since it's based on their distance from the ground station. 

This is a common problem in monitoring and analyzing sensor data. To solve this, an optimal merge algorithm is used with heaps and greedy solutions.
