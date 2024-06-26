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

import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * <em>WARNING: GENERATED CODE</em>
 *
 * <p>A cache that provides the following features:
 *
 * <ul>
 *   <li>Stats
 *   <li>WeakKeys (inherited)
 *   <li>InfirmValues (inherited)
 * </ul>
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings("MissingOverride")
class WIS<K, V> extends WI<K, V> {
  static final LocalCacheFactory FACTORY = WIS::new;

  final StatsCounter statsCounter;

  WIS(Caffeine<K, V> builder,  AsyncCacheLoader<? super K, V> cacheLoader, boolean async) {
    super(builder, cacheLoader, async);
    this.statsCounter = builder.getStatsCounterSupplier().get();
  }

  public final boolean isRecordingStats() {
    return true;
  }

  public final Ticker statsTicker() {
    return Ticker.systemTicker();
  }

  public final StatsCounter statsCounter() {
    return statsCounter;
  }
}
