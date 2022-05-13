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

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.tuweni.bytes.Bytes;
import org.web3j.rlp.RlpList;
import org.web3j.rlp.RlpString;

@JsonSerialize(using = TesseraBase64String.Serializer.class)
@JsonDeserialize(using = TesseraBase64String.Deserializer.class)
public class TesseraBase64String {

  public static class Serializer extends JsonSerializer<Object> {
    @Override
    public void serialize(
        final Object value, final JsonGenerator gen, final SerializerProvider serializers)
        throws IOException {
      gen.writeString(value.toString());
    }
  }

  public static class Deserializer extends JsonDeserializer<Object> {
    @Override
    public Object deserialize(final JsonParser p, final DeserializationContext ctxt)
        throws IOException {
      return TesseraBase64String.wrap(p.getText());
    }
  }

  private final Bytes enclaveB64Value;

  private TesseraBase64String(final String base64String) {
    this.enclaveB64Value = Bytes.fromBase64String(base64String);
  }

  private TesseraBase64String(final byte[] base64ByteArray) {
    this.enclaveB64Value = Bytes.wrap(Base64.getDecoder().decode(base64ByteArray));
  }

  public static TesseraBase64String wrap(final String base64String) {
    return new TesseraBase64String(base64String);
  }

  public static TesseraBase64String wrap(final byte[] base64Array) {
    return new TesseraBase64String(base64Array);
  }

  public static List<TesseraBase64String> wrapList(final List<String> base64Strings) {
    return base64Strings.stream().map(TesseraBase64String::wrap).collect(Collectors.toList());
  }

  public static List<TesseraBase64String> wrapList(final String... base64Strings) {
    return Arrays.stream(base64Strings).map(TesseraBase64String::wrap).collect(Collectors.toList());
  }

  public static List<String> unwrapList(final List<TesseraBase64String> base64Strings) {
    return base64Strings.stream().map(TesseraBase64String::toString).collect(Collectors.toList());
  }

  public static RlpList unwrapListToRlp(final List<TesseraBase64String> base64Strings) {
    return new RlpList(
        base64Strings.stream().map(TesseraBase64String::asRlp).collect(Collectors.toList()));
  }

  public byte[] raw() {
    return enclaveB64Value.toArrayUnsafe();
  }

  public RlpString asRlp() {
    return RlpString.create(raw());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TesseraBase64String that = (TesseraBase64String) o;
    return enclaveB64Value.equals(that.enclaveB64Value);
  }

  @Override
  public int hashCode() {
    return enclaveB64Value.hashCode();
  }

  @Override
  public String toString() {
    return enclaveB64Value.toBase64String();
  }
}
