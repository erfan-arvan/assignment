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

/**
 * <em>WARNING: GENERATED CODE</em>
 *
 * <p>A cache entry that provides the following features:
 *
 * <ul>
 *   <li>MaximumSize
 *   <li>WeakKeys (inherited)
 *   <li>StrongValues (inherited)
 *   <li>ExpireAccess (inherited)
 *   <li>ExpireWrite (inherited)
 * </ul>
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings({"MissingOverride", "NullAway"})
final class FSAWMS<K, V> extends FSAW<K, V> {
  int queueType;

  FSAWMS() {}

  FSAWMS(
      K key,
      ReferenceQueue<K> keyReferenceQueue,
      V value,
      ReferenceQueue<V> valueReferenceQueue,
      int weight,
      long now) {
    super(key, keyReferenceQueue, value, valueReferenceQueue, weight, now);
  }

  FSAWMS(
      Object keyReference, V value, ReferenceQueue<V> valueReferenceQueue, int weight, long now) {
    super(keyReference, value, valueReferenceQueue, weight, now);
  }

  public int getQueueType() {
    return queueType;
  }

  public void setQueueType(int queueType) {
    this.queueType = queueType;
  }

  public Node<K, V> newNode(
      K key,
      ReferenceQueue<K> keyReferenceQueue,
      V value,
      ReferenceQueue<V> valueReferenceQueue,
      int weight,
      long now) {
    return new FSAWMS<>(key, keyReferenceQueue, value, valueReferenceQueue, weight, now);
  }

  public Node<K, V> newNode(
      Object keyReference, V value, ReferenceQueue<V> valueReferenceQueue, int weight, long now) {
    return new FSAWMS<>(keyReference, value, valueReferenceQueue, weight, now);
  }
}
