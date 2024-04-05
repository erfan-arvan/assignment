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

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.ref.ReferenceQueue;

/**
 * <em>WARNING: GENERATED CODE</em>
 *
 * <p>A cache entry that provides the following features:
 *
 * <ul>
 *   <li>ExpireWrite
 *   <li>StrongKeys (inherited)
 *   <li>SoftValues (inherited)
 *   <li>ExpireAccess (inherited)
 * </ul>
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings({"MissingOverride", "NullAway"})
class PDAW<K, V> extends PDA<K, V> {
  protected static final VarHandle WRITE_TIME;

  static {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    try {
      WRITE_TIME = lookup.findVarHandle(PDAW.class, NodeFactory.WRITE_TIME, long.class);
    } catch (ReflectiveOperationException e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  volatile long writeTime;

  Node<K, V> previousInWriteOrder;

  Node<K, V> nextInWriteOrder;

  PDAW() {}

  PDAW(
      K key,
      ReferenceQueue<K> keyReferenceQueue,
      V value,
      ReferenceQueue<V> valueReferenceQueue,
      int weight,
      long now) {
    super(key, keyReferenceQueue, value, valueReferenceQueue, weight, now);
    WRITE_TIME.set(this, now & ~1L);
  }

  PDAW(Object keyReference, V value, ReferenceQueue<V> valueReferenceQueue, int weight, long now) {
    super(keyReference, value, valueReferenceQueue, weight, now);
    WRITE_TIME.set(this, now & ~1L);
  }

  public Node<K, V> getPreviousInVariableOrder() {
    return previousInWriteOrder;
  }

  public void setPreviousInVariableOrder(Node<K, V> previousInWriteOrder) {
    this.previousInWriteOrder = previousInWriteOrder;
  }

  public Node<K, V> getNextInVariableOrder() {
    return nextInWriteOrder;
  }

  public void setNextInVariableOrder(Node<K, V> nextInWriteOrder) {
    this.nextInWriteOrder = nextInWriteOrder;
  }

  public long getVariableTime() {
    return (long) WRITE_TIME.getOpaque(this);
  }

  public void setVariableTime(long writeTime) {
    WRITE_TIME.setOpaque(this, writeTime);
  }

  public boolean casVariableTime(long expect, long update) {
    return (writeTime == expect) && WRITE_TIME.compareAndSet(this, expect, update);
  }

  public final long getWriteTime() {
    return (long) WRITE_TIME.getOpaque(this);
  }

  public final void setWriteTime(long writeTime) {
    WRITE_TIME.set(this, writeTime);
  }

  public final Node<K, V> getPreviousInWriteOrder() {
    return previousInWriteOrder;
  }

  public final void setPreviousInWriteOrder(Node<K, V> previousInWriteOrder) {
    this.previousInWriteOrder = previousInWriteOrder;
  }

  public final Node<K, V> getNextInWriteOrder() {
    return nextInWriteOrder;
  }

  public final void setNextInWriteOrder(Node<K, V> nextInWriteOrder) {
    this.nextInWriteOrder = nextInWriteOrder;
  }

  public Node<K, V> newNode(
      K key,
      ReferenceQueue<K> keyReferenceQueue,
      V value,
      ReferenceQueue<V> valueReferenceQueue,
      int weight,
      long now) {
    return new PDAW<>(key, keyReferenceQueue, value, valueReferenceQueue, weight, now);
  }

  public Node<K, V> newNode(
      Object keyReference, V value, ReferenceQueue<V> valueReferenceQueue, int weight, long now) {
    return new PDAW<>(keyReference, value, valueReferenceQueue, weight, now);
  }
}
