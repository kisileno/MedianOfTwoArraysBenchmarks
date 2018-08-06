package org.kisileno;

import org.kisileno.median.LeetCodeMedianFinder;
import org.kisileno.median.MedianFinder;
import org.kisileno.median.MergeFinderImpl;
import org.kisileno.median.SystemArrayCopyMedianFinder;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

public class MedianBenchmark {

    @State(Scope.Thread)
    public static class MedianState {
       public  int[]  arr1 = MedianFinder.generateSortedArray(10000);
       public  int[]  arr2 = MedianFinder.generateSortedArray(10000);
       public  MedianFinder arrayCopy = new SystemArrayCopyMedianFinder();
       public  MedianFinder leetCode = new LeetCodeMedianFinder();
       public  MedianFinder merge = new MergeFinderImpl();

    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void arrayCopyTest(MedianState state, Blackhole bh) {
        bh.consume(state.arrayCopy.findMedianSortedArrays(state.arr1, state.arr2));
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void leetCodeTest(MedianState state, Blackhole bh) {
        bh.consume(state.leetCode.findMedianSortedArrays(state.arr1, state.arr2));
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void mergeTest(MedianState state, Blackhole bh) {
        bh.consume(state.merge.findMedianSortedArrays(state.arr1, state.arr2));
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MedianBenchmark.class.getSimpleName())
                .forks(1)
                .measurementIterations(3)
                .timeout(TimeValue.seconds(10))
                .warmupIterations(3)
                .warmupTime(TimeValue.seconds(10))

                .build();

        new Runner(opt).run();
    }

}
