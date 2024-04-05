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

import com.github.benmanes.caffeine.cache.References.SoftValueReference;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * <em>WARNING: GENERATED CODE</em>
 *
 * <p>A cache entry that provides the following features:
 *
 * <ul>
 *   <li>StrongKeys
 *   <li>SoftValues
 * </ul>
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings({"MissingOverride", "NullAway", "PMD.UnusedFormalParameter", "unchecked"})
class PD<K, V> extends Node<K, V> implements NodeFactory<K, V> {
  protected static final VarHandle VALUE;

  static {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    try {
      VALUE = lookup.findVarHandle(PD.class, NodeFactory.VALUE, SoftValueReference.class);
    } catch (ReflectiveOperationException e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  volatile SoftValueReference<V> value;

  PD() {}

  PD(
      K key,
      ReferenceQueue<K> keyReferenceQueue,
      V value,
      ReferenceQueue<V> valueReferenceQueue,
      int weight,
      long now) {
    this(key, value, valueReferenceQueue, weight, now);
  }

  PD(Object keyReference, V value, ReferenceQueue<V> valueReferenceQueue, int weight, long now) {
    VALUE.set(this, new SoftValueReference<V>(keyReference, value, valueReferenceQueue));
  }

  public final Object getKeyReference() {
    SoftValueReference<V> valueRef = (SoftValueReference<V>) VALUE.get(this);
    return valueRef.getKeyReference();
  }

  public final K getKey() {
    SoftValueReference<V> valueRef = (SoftValueReference<V>) VALUE.get(this);
    return (K) valueRef.getKeyReference();
  }

  public final V getValue() {
    for (; ; ) {
      Reference<V> ref = (Reference<V>) VALUE.getOpaque(this);
      V referent = ref.get();
      if ((referent != null) || (ref == VALUE.getAcquire(this))) {
        return referent;
      }
    }
  }

  public final Object getValueReference() {
    return VALUE.get(this);
  }

  public final void setValue(V value, ReferenceQueue<V> referenceQueue) {
    Reference<V> ref = (Reference<V>) VALUE.get(this);
    VALUE.setRelease(this, new SoftValueReference<V>(getKeyReference(), value, referenceQueue));
    ref.clear();
  }

  public final boolean containsValue(Object value) {
    return getValue() == value;
  }

  public Node<K, V> newNode(
      K key,
      ReferenceQueue<K> keyReferenceQueue,
      V value,
      ReferenceQueue<V> valueReferenceQueue,
      int weight,
      long now) {
    return new PD<>(key, keyReferenceQueue, value, valueReferenceQueue, weight, now);
  }

  public Node<K, V> newNode(
      Object keyReference, V value, ReferenceQueue<V> valueReferenceQueue, int weight, long now) {
    return new PD<>(keyReference, value, valueReferenceQueue, weight, now);
  }

  public boolean softValues() {
    return true;
  }

  public final boolean isAlive() {
    Object key = getKeyReference();
    return (key != RETIRED_STRONG_KEY) && (key != DEAD_STRONG_KEY);
  }

  public final boolean isRetired() {
    return (getKeyReference() == RETIRED_STRONG_KEY);
  }

  public final void retire() {
    SoftValueReference<V> valueRef = (SoftValueReference<V>) VALUE.get(this);
    valueRef.setKeyReference(RETIRED_STRONG_KEY);
    valueRef.clear();
  }

  public final boolean isDead() {
    return (getKeyReference() == DEAD_STRONG_KEY);
  }

  public final void die() {
    SoftValueReference<V> valueRef = (SoftValueReference<V>) VALUE.get(this);
    valueRef.setKeyReference(DEAD_STRONG_KEY);
    valueRef.clear();
  }
}
