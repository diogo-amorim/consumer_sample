/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class scheduleEntryID extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1065968243265918469L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"scheduleEntryID\",\"namespace\":\"net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis\",\"fields\":[{\"name\":\"scheduleEntryKey\",\"type\":\"string\"},{\"name\":\"scheduleEntryIdentifier\",\"type\":{\"type\":\"record\",\"name\":\"scheduleEntryIdentifier\",\"fields\":[{\"name\":\"vessel\",\"type\":{\"type\":\"record\",\"name\":\"vessel\",\"fields\":[{\"name\":\"vesselCode\",\"type\":\"string\"},{\"name\":\"IMONumber\",\"type\":\"string\"},{\"name\":\"vesselName\",\"type\":\"string\"},{\"name\":\"vesselOperatorCode\",\"type\":\"string\"},{\"name\":\"vesselFlag\",\"type\":\"string\"},{\"name\":\"vesselCallSign\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.vessel\"}},{\"name\":\"arrivalVoyage\",\"type\":{\"type\":\"record\",\"name\":\"arrivalVoyage\",\"fields\":[{\"name\":\"voyage\",\"type\":\"string\"},{\"name\":\"direction\",\"type\":\"string\"},{\"name\":\"transportMode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.arrivalVoyage\"}},{\"name\":\"departureVoyage\",\"type\":{\"type\":\"record\",\"name\":\"departureVoyage\",\"fields\":[{\"name\":\"voyage\",\"type\":\"string\"},{\"name\":\"direction\",\"type\":\"string\"},{\"name\":\"transportMode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.departureVoyage\"}},{\"name\":\"service\",\"type\":{\"type\":\"record\",\"name\":\"service\",\"fields\":[{\"name\":\"code\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.service\"}},{\"name\":\"previousPortCall\",\"type\":{\"type\":\"record\",\"name\":\"previousPortCall\",\"fields\":[{\"name\":\"cityCode\",\"type\":\"string\"},{\"name\":\"terminalCode\",\"type\":\"string\"},{\"name\":\"cityName\",\"type\":\"string\"},{\"name\":\"terminalName\",\"type\":\"string\"},{\"name\":\"geoCode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.previousPortCall\"}},{\"name\":\"currentPortCall\",\"type\":{\"type\":\"record\",\"name\":\"currentPortCall\",\"fields\":[{\"name\":\"cityCode\",\"type\":\"string\"},{\"name\":\"terminalCode\",\"type\":\"string\"},{\"name\":\"cityName\",\"type\":\"string\"},{\"name\":\"terminalName\",\"type\":\"string\"},{\"name\":\"geoCode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.currentPortCall\"}},{\"name\":\"nextPortCall\",\"type\":{\"type\":\"record\",\"name\":\"nextPortCall\",\"fields\":[{\"name\":\"cityCode\",\"type\":\"string\"},{\"name\":\"terminalCode\",\"type\":\"string\"},{\"name\":\"cityName\",\"type\":\"string\"},{\"name\":\"terminalName\",\"type\":\"string\"},{\"name\":\"geoCode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.nextPortCall\"}}],\"connect.name\":\"emp.maersk.com.scheduleEntryIdentifier\"}}],\"connect.name\":\"emp.maersk.com.scheduleEntryID\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<scheduleEntryID> ENCODER =
      new BinaryMessageEncoder<scheduleEntryID>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<scheduleEntryID> DECODER =
      new BinaryMessageDecoder<scheduleEntryID>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<scheduleEntryID> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<scheduleEntryID> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<scheduleEntryID> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<scheduleEntryID>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this scheduleEntryID to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a scheduleEntryID from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a scheduleEntryID instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static scheduleEntryID fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence scheduleEntryKey;
  @Deprecated public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier scheduleEntryIdentifier;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public scheduleEntryID() {}

  /**
   * All-args constructor.
   * @param scheduleEntryKey The new value for scheduleEntryKey
   * @param scheduleEntryIdentifier The new value for scheduleEntryIdentifier
   */
  public scheduleEntryID(java.lang.CharSequence scheduleEntryKey, net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier scheduleEntryIdentifier) {
    this.scheduleEntryKey = scheduleEntryKey;
    this.scheduleEntryIdentifier = scheduleEntryIdentifier;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return scheduleEntryKey;
    case 1: return scheduleEntryIdentifier;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: scheduleEntryKey = (java.lang.CharSequence)value$; break;
    case 1: scheduleEntryIdentifier = (net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'scheduleEntryKey' field.
   * @return The value of the 'scheduleEntryKey' field.
   */
  public java.lang.CharSequence getScheduleEntryKey() {
    return scheduleEntryKey;
  }


  /**
   * Sets the value of the 'scheduleEntryKey' field.
   * @param value the value to set.
   */
  public void setScheduleEntryKey(java.lang.CharSequence value) {
    this.scheduleEntryKey = value;
  }

  /**
   * Gets the value of the 'scheduleEntryIdentifier' field.
   * @return The value of the 'scheduleEntryIdentifier' field.
   */
  public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier getScheduleEntryIdentifier() {
    return scheduleEntryIdentifier;
  }


  /**
   * Sets the value of the 'scheduleEntryIdentifier' field.
   * @param value the value to set.
   */
  public void setScheduleEntryIdentifier(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier value) {
    this.scheduleEntryIdentifier = value;
  }

  /**
   * Creates a new scheduleEntryID RecordBuilder.
   * @return A new scheduleEntryID RecordBuilder
   */
  public static net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder newBuilder() {
    return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder();
  }

  /**
   * Creates a new scheduleEntryID RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new scheduleEntryID RecordBuilder
   */
  public static net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder newBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder other) {
    if (other == null) {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder();
    } else {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder(other);
    }
  }

  /**
   * Creates a new scheduleEntryID RecordBuilder by copying an existing scheduleEntryID instance.
   * @param other The existing instance to copy.
   * @return A new scheduleEntryID RecordBuilder
   */
  public static net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder newBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID other) {
    if (other == null) {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder();
    } else {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder(other);
    }
  }

  /**
   * RecordBuilder for scheduleEntryID instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<scheduleEntryID>
    implements org.apache.avro.data.RecordBuilder<scheduleEntryID> {

    private java.lang.CharSequence scheduleEntryKey;
    private net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier scheduleEntryIdentifier;
    private net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier.Builder scheduleEntryIdentifierBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.scheduleEntryKey)) {
        this.scheduleEntryKey = data().deepCopy(fields()[0].schema(), other.scheduleEntryKey);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.scheduleEntryIdentifier)) {
        this.scheduleEntryIdentifier = data().deepCopy(fields()[1].schema(), other.scheduleEntryIdentifier);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasScheduleEntryIdentifierBuilder()) {
        this.scheduleEntryIdentifierBuilder = net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier.newBuilder(other.getScheduleEntryIdentifierBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing scheduleEntryID instance
     * @param other The existing instance to copy.
     */
    private Builder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.scheduleEntryKey)) {
        this.scheduleEntryKey = data().deepCopy(fields()[0].schema(), other.scheduleEntryKey);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.scheduleEntryIdentifier)) {
        this.scheduleEntryIdentifier = data().deepCopy(fields()[1].schema(), other.scheduleEntryIdentifier);
        fieldSetFlags()[1] = true;
      }
      this.scheduleEntryIdentifierBuilder = null;
    }

    /**
      * Gets the value of the 'scheduleEntryKey' field.
      * @return The value.
      */
    public java.lang.CharSequence getScheduleEntryKey() {
      return scheduleEntryKey;
    }


    /**
      * Sets the value of the 'scheduleEntryKey' field.
      * @param value The value of 'scheduleEntryKey'.
      * @return This builder.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder setScheduleEntryKey(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.scheduleEntryKey = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'scheduleEntryKey' field has been set.
      * @return True if the 'scheduleEntryKey' field has been set, false otherwise.
      */
    public boolean hasScheduleEntryKey() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'scheduleEntryKey' field.
      * @return This builder.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder clearScheduleEntryKey() {
      scheduleEntryKey = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'scheduleEntryIdentifier' field.
      * @return The value.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier getScheduleEntryIdentifier() {
      return scheduleEntryIdentifier;
    }


    /**
      * Sets the value of the 'scheduleEntryIdentifier' field.
      * @param value The value of 'scheduleEntryIdentifier'.
      * @return This builder.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder setScheduleEntryIdentifier(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier value) {
      validate(fields()[1], value);
      this.scheduleEntryIdentifierBuilder = null;
      this.scheduleEntryIdentifier = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'scheduleEntryIdentifier' field has been set.
      * @return True if the 'scheduleEntryIdentifier' field has been set, false otherwise.
      */
    public boolean hasScheduleEntryIdentifier() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'scheduleEntryIdentifier' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier.Builder getScheduleEntryIdentifierBuilder() {
      if (scheduleEntryIdentifierBuilder == null) {
        if (hasScheduleEntryIdentifier()) {
          setScheduleEntryIdentifierBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier.newBuilder(scheduleEntryIdentifier));
        } else {
          setScheduleEntryIdentifierBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier.newBuilder());
        }
      }
      return scheduleEntryIdentifierBuilder;
    }

    /**
     * Sets the Builder instance for the 'scheduleEntryIdentifier' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder setScheduleEntryIdentifierBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier.Builder value) {
      clearScheduleEntryIdentifier();
      scheduleEntryIdentifierBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'scheduleEntryIdentifier' field has an active Builder instance
     * @return True if the 'scheduleEntryIdentifier' field has an active Builder instance
     */
    public boolean hasScheduleEntryIdentifierBuilder() {
      return scheduleEntryIdentifierBuilder != null;
    }

    /**
      * Clears the value of the 'scheduleEntryIdentifier' field.
      * @return This builder.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID.Builder clearScheduleEntryIdentifier() {
      scheduleEntryIdentifier = null;
      scheduleEntryIdentifierBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public scheduleEntryID build() {
      try {
        scheduleEntryID record = new scheduleEntryID();
        record.scheduleEntryKey = fieldSetFlags()[0] ? this.scheduleEntryKey : (java.lang.CharSequence) defaultValue(fields()[0]);
        if (scheduleEntryIdentifierBuilder != null) {
          try {
            record.scheduleEntryIdentifier = this.scheduleEntryIdentifierBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("scheduleEntryIdentifier"));
            throw e;
          }
        } else {
          record.scheduleEntryIdentifier = fieldSetFlags()[1] ? this.scheduleEntryIdentifier : (net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier) defaultValue(fields()[1]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<scheduleEntryID>
    WRITER$ = (org.apache.avro.io.DatumWriter<scheduleEntryID>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<scheduleEntryID>
    READER$ = (org.apache.avro.io.DatumReader<scheduleEntryID>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.scheduleEntryKey);

    this.scheduleEntryIdentifier.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.scheduleEntryKey = in.readString(this.scheduleEntryKey instanceof Utf8 ? (Utf8)this.scheduleEntryKey : null);

      if (this.scheduleEntryIdentifier == null) {
        this.scheduleEntryIdentifier = new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier();
      }
      this.scheduleEntryIdentifier.customDecode(in);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.scheduleEntryKey = in.readString(this.scheduleEntryKey instanceof Utf8 ? (Utf8)this.scheduleEntryKey : null);
          break;

        case 1:
          if (this.scheduleEntryIdentifier == null) {
            this.scheduleEntryIdentifier = new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryIdentifier();
          }
          this.scheduleEntryIdentifier.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










