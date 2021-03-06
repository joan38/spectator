/*
 * Copyright 2014-2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spectator.api;

import com.netflix.spectator.impl.SwapMeter;

/** Wraps another counter allowing the underlying type to be swapped. */
final class SwapCounter extends SwapMeter<Counter> implements Counter {

  /** Create a new instance. */
  SwapCounter(Registry registry, Id id, Counter underlying) {
    super(registry, id, underlying);
  }

  @Override public Counter lookup() {
    return registry.counter(id);
  }

  @Override public void add(double amount) {
    get().add(amount);
  }

  @Override public double actualCount() {
    return get().actualCount();
  }
}
