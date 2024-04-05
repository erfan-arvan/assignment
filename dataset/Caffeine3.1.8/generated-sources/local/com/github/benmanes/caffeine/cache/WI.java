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

import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * <em>WARNING: GENERATED CODE</em>
 *
 * <p>A cache that provides the following features:
 *
 * <ul>
 *   <li>WeakKeys
 *   <li>InfirmValues
 * </ul>
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings({"MissingOverride", "unchecked"})
class WI<K, V> extends BoundedLocalCache<K, V> {
  static final LocalCacheFactory FACTORY = WI::new;

  final ReferenceQueue<K> keyReferenceQueue = new ReferenceQueue<K>();

  final ReferenceQueue<V> valueReferenceQueue = new ReferenceQueue<V>();

  WI(Caffeine<K, V> builder, @Nullable AsyncCacheLoader<? super K, V> cacheLoader, boolean async) {
    super(builder, (AsyncCacheLoader<K, V>) cacheLoader, async);
  }

  protected final ReferenceQueue<K> keyReferenceQueue() {
    return keyReferenceQueue;
  }

  protected final boolean collectKeys() {
    return true;
  }

  protected final ReferenceQueue<V> valueReferenceQueue() {
    return valueReferenceQueue;
  }

  protected final boolean collectValues() {
    return true;
  }
}
