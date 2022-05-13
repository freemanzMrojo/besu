/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.tests.acceptance.dsl.privacy.web3j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.web3j.crypto.Hash;
import org.web3j.rlp.RlpEncoder;
import org.web3j.rlp.RlpList;
import org.web3j.rlp.RlpString;
import org.web3j.rlp.RlpType;
import org.web3j.utils.Base64String;

public class PrivacyGroupUtils {
  public static Base64String generateLegacyGroup(
      final TesseraBase64String privateFrom, final List<TesseraBase64String> privateFor) {
    final List<byte[]> stringList = new ArrayList<>();
    stringList.add(Base64.getDecoder().decode(privateFrom.toString()));
    privateFor.forEach(item -> stringList.add(item.raw()));

    final List<RlpType> rlpList =
        stringList.stream()
            .distinct()
            .sorted(Comparator.comparing(Arrays::hashCode))
            .map(RlpString::create)
            .collect(Collectors.toList());

    return Base64String.wrap(Hash.sha3(RlpEncoder.encode(new RlpList(rlpList))));
  }
}
