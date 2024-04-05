// Copyright 2024 Ben Manes. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.github.benmanes.caffeine.cache;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * <em>WARNING: GENERATED CODE</em>
 *
 * <p>A cache that provides the following features:
 *
 * <ul>
 *   <li>MaximumWeight
 *   <li>StrongKeys (inherited)
 *   <li>InfirmValues (inherited)
 *   <li>Stats (inherited)
 * </ul>
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings({"MissingOverride", "NullAway"})
class SISMW<K, V> extends SIS<K, V> {
  static final LocalCacheFactory FACTORY = SISMW::new;

  long maximum;

  long weightedSize;

  long windowMaximum;

  long windowWeightedSize;

  long mainProtectedMaximum;

  long mainProtectedWeightedSize;

  double stepSize;

  long adjustment;

  int hitsInSample;

  int missesInSample;

  double previousSampleHitRate;

  final FrequencySketch<K> sketch;

  final AccessOrderDeque<Node<K, V>> accessOrderWindowDeque;

  final AccessOrderDeque<Node<K, V>> accessOrderProbationDeque;

  final AccessOrderDeque<Node<K, V>> accessOrderProtectedDeque;

  SISMW(
      Caffeine<K, V> builder,  AsyncCacheLoader<? super K, V> cacheLoader, boolean async) {
    super(builder, cacheLoader, async);
    this.sketch = new FrequencySketch<K>();
    if (builder.hasInitialCapacity()) {
      long capacity = Math.min(builder.getMaximum(), builder.getInitialCapacity());
      this.sketch.ensureCapacity(capacity);
    }
    this.accessOrderWindowDeque =
        builder.evicts() || builder.expiresAfterAccess()
            ? new AccessOrderDeque<Node<K, V>>()
            : null;
    this.accessOrderProbationDeque = new AccessOrderDeque<Node<K, V>>();
    this.accessOrderProtectedDeque = new AccessOrderDeque<Node<K, V>>();
  }

  protected final boolean evicts() {
    return true;
  }

  protected final long maximum() {
    return maximum;
  }

  protected final void setMaximum(long maximum) {
    this.maximum = maximum;
  }

  protected final long weightedSize() {
    return weightedSize;
  }

  protected final void setWeightedSize(long weightedSize) {
    this.weightedSize = weightedSize;
  }

  protected final long windowMaximum() {
    return windowMaximum;
  }

  protected final void setWindowMaximum(long windowMaximum) {
    this.windowMaximum = windowMaximum;
  }

  protected final long windowWeightedSize() {
    return windowWeightedSize;
  }

  protected final void setWindowWeightedSize(long windowWeightedSize) {
    this.windowWeightedSize = windowWeightedSize;
  }

  protected final long mainProtectedMaximum() {
    return mainProtectedMaximum;
  }

  protected final void setMainProtectedMaximum(long mainProtectedMaximum) {
    this.mainProtectedMaximum = mainProtectedMaximum;
  }

  protected final long mainProtectedWeightedSize() {
    return mainProtectedWeightedSize;
  }

  protected final void setMainProtectedWeightedSize(long mainProtectedWeightedSize) {
    this.mainProtectedWeightedSize = mainProtectedWeightedSize;
  }

  protected final double stepSize() {
    return stepSize;
  }

  protected final void setStepSize(double stepSize) {
    this.stepSize = stepSize;
  }

  protected final long adjustment() {
    return adjustment;
  }

  protected final void setAdjustment(long adjustment) {
    this.adjustment = adjustment;
  }

  protected final int hitsInSample() {
    return hitsInSample;
  }

  protected final void setHitsInSample(int hitsInSample) {
    this.hitsInSample = hitsInSample;
  }

  protected final int missesInSample() {
    return missesInSample;
  }

  protected final void setMissesInSample(int missesInSample) {
    this.missesInSample = missesInSample;
  }

  protected final double previousSampleHitRate() {
    return previousSampleHitRate;
  }

  protected final void setPreviousSampleHitRate(double previousSampleHitRate) {
    this.previousSampleHitRate = previousSampleHitRate;
  }

  protected final FrequencySketch<K> frequencySketch() {
    return sketch;
  }

  protected final AccessOrderDeque<Node<K, V>> accessOrderWindowDeque() {
    return accessOrderWindowDeque;
  }

  protected final AccessOrderDeque<Node<K, V>> accessOrderProbationDeque() {
    return accessOrderProbationDeque;
  }

  protected final AccessOrderDeque<Node<K, V>> accessOrderProtectedDeque() {
    return accessOrderProtectedDeque;
  }
}
