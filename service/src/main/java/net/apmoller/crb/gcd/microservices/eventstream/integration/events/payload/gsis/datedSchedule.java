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
public class datedSchedule extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6977986746758355614L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"datedSchedule\",\"namespace\":\"net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis\",\"fields\":[{\"name\":\"scheduleEntries\",\"type\":{\"type\":\"record\",\"name\":\"scheduleEntries\",\"fields\":[{\"name\":\"scheduleEntry\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"scheduleEntry_record\",\"fields\":[{\"name\":\"rotationId\",\"type\":\"string\"},{\"name\":\"rotationName\",\"type\":\"string\"},{\"name\":\"rotationVersion\",\"type\":\"string\"},{\"name\":\"scheduleEntryID\",\"type\":{\"type\":\"record\",\"name\":\"scheduleEntryID\",\"fields\":[{\"name\":\"scheduleEntryKey\",\"type\":\"string\"},{\"name\":\"scheduleEntryIdentifier\",\"type\":{\"type\":\"record\",\"name\":\"scheduleEntryIdentifier\",\"fields\":[{\"name\":\"vessel\",\"type\":{\"type\":\"record\",\"name\":\"vessel\",\"fields\":[{\"name\":\"vesselCode\",\"type\":\"string\"},{\"name\":\"IMONumber\",\"type\":\"string\"},{\"name\":\"vesselName\",\"type\":\"string\"},{\"name\":\"vesselOperatorCode\",\"type\":\"string\"},{\"name\":\"vesselFlag\",\"type\":\"string\"},{\"name\":\"vesselCallSign\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.vessel\"}},{\"name\":\"arrivalVoyage\",\"type\":{\"type\":\"record\",\"name\":\"arrivalVoyage\",\"fields\":[{\"name\":\"voyage\",\"type\":\"string\"},{\"name\":\"direction\",\"type\":\"string\"},{\"name\":\"transportMode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.arrivalVoyage\"}},{\"name\":\"departureVoyage\",\"type\":{\"type\":\"record\",\"name\":\"departureVoyage\",\"fields\":[{\"name\":\"voyage\",\"type\":\"string\"},{\"name\":\"direction\",\"type\":\"string\"},{\"name\":\"transportMode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.departureVoyage\"}},{\"name\":\"service\",\"type\":{\"type\":\"record\",\"name\":\"service\",\"fields\":[{\"name\":\"code\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.service\"}},{\"name\":\"previousPortCall\",\"type\":{\"type\":\"record\",\"name\":\"previousPortCall\",\"fields\":[{\"name\":\"cityCode\",\"type\":\"string\"},{\"name\":\"terminalCode\",\"type\":\"string\"},{\"name\":\"cityName\",\"type\":\"string\"},{\"name\":\"terminalName\",\"type\":\"string\"},{\"name\":\"geoCode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.previousPortCall\"}},{\"name\":\"currentPortCall\",\"type\":{\"type\":\"record\",\"name\":\"currentPortCall\",\"fields\":[{\"name\":\"cityCode\",\"type\":\"string\"},{\"name\":\"terminalCode\",\"type\":\"string\"},{\"name\":\"cityName\",\"type\":\"string\"},{\"name\":\"terminalName\",\"type\":\"string\"},{\"name\":\"geoCode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.currentPortCall\"}},{\"name\":\"nextPortCall\",\"type\":{\"type\":\"record\",\"name\":\"nextPortCall\",\"fields\":[{\"name\":\"cityCode\",\"type\":\"string\"},{\"name\":\"terminalCode\",\"type\":\"string\"},{\"name\":\"cityName\",\"type\":\"string\"},{\"name\":\"terminalName\",\"type\":\"string\"},{\"name\":\"geoCode\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.nextPortCall\"}}],\"connect.name\":\"emp.maersk.com.scheduleEntryIdentifier\"}}],\"connect.name\":\"emp.maersk.com.scheduleEntryID\"}},{\"name\":\"siteCallStatus\",\"type\":\"string\"},{\"name\":\"schedule\",\"type\":{\"type\":\"record\",\"name\":\"schedule\",\"fields\":[{\"name\":\"proformaArrival\",\"type\":\"string\"},{\"name\":\"proformaDeparture\",\"type\":\"string\"},{\"name\":\"scheduledArrival\",\"type\":\"string\"},{\"name\":\"scheduledDeparture\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.schedule\"}},{\"name\":\"dummyCall\",\"type\":\"string\"},{\"name\":\"omitReason\",\"type\":\"string\"},{\"name\":\"actual\",\"type\":{\"type\":\"record\",\"name\":\"actual\",\"fields\":[{\"name\":\"actualArrival\",\"type\":\"string\"},{\"name\":\"actualDeparture\",\"type\":\"string\"},{\"name\":\"arrivalAtPilotStation\",\"type\":\"string\"},{\"name\":\"firstPilotOnBoard\",\"type\":\"string\"},{\"name\":\"pilotOff\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.actual\"}},{\"name\":\"notes\",\"type\":\"string\"}],\"connect.name\":\"emp.maersk.com.scheduleEntry_record\"}}}],\"connect.name\":\"emp.maersk.com.scheduleEntries\"}}],\"connect.name\":\"emp.maersk.com.datedSchedule\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<datedSchedule> ENCODER =
      new BinaryMessageEncoder<datedSchedule>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<datedSchedule> DECODER =
      new BinaryMessageDecoder<datedSchedule>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<datedSchedule> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<datedSchedule> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<datedSchedule> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<datedSchedule>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this datedSchedule to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a datedSchedule from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a datedSchedule instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static datedSchedule fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries scheduleEntries;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public datedSchedule() {}

  /**
   * All-args constructor.
   * @param scheduleEntries The new value for scheduleEntries
   */
  public datedSchedule(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries scheduleEntries) {
    this.scheduleEntries = scheduleEntries;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return scheduleEntries;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: scheduleEntries = (net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'scheduleEntries' field.
   * @return The value of the 'scheduleEntries' field.
   */
  public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries getScheduleEntries() {
    return scheduleEntries;
  }


  /**
   * Sets the value of the 'scheduleEntries' field.
   * @param value the value to set.
   */
  public void setScheduleEntries(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries value) {
    this.scheduleEntries = value;
  }

  /**
   * Creates a new datedSchedule RecordBuilder.
   * @return A new datedSchedule RecordBuilder
   */
  public static net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder newBuilder() {
    return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder();
  }

  /**
   * Creates a new datedSchedule RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new datedSchedule RecordBuilder
   */
  public static net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder newBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder other) {
    if (other == null) {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder();
    } else {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder(other);
    }
  }

  /**
   * Creates a new datedSchedule RecordBuilder by copying an existing datedSchedule instance.
   * @param other The existing instance to copy.
   * @return A new datedSchedule RecordBuilder
   */
  public static net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder newBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule other) {
    if (other == null) {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder();
    } else {
      return new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder(other);
    }
  }

  /**
   * RecordBuilder for datedSchedule instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<datedSchedule>
    implements org.apache.avro.data.RecordBuilder<datedSchedule> {

    private net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries scheduleEntries;
    private net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries.Builder scheduleEntriesBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.scheduleEntries)) {
        this.scheduleEntries = data().deepCopy(fields()[0].schema(), other.scheduleEntries);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasScheduleEntriesBuilder()) {
        this.scheduleEntriesBuilder = net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries.newBuilder(other.getScheduleEntriesBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing datedSchedule instance
     * @param other The existing instance to copy.
     */
    private Builder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.scheduleEntries)) {
        this.scheduleEntries = data().deepCopy(fields()[0].schema(), other.scheduleEntries);
        fieldSetFlags()[0] = true;
      }
      this.scheduleEntriesBuilder = null;
    }

    /**
      * Gets the value of the 'scheduleEntries' field.
      * @return The value.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries getScheduleEntries() {
      return scheduleEntries;
    }


    /**
      * Sets the value of the 'scheduleEntries' field.
      * @param value The value of 'scheduleEntries'.
      * @return This builder.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder setScheduleEntries(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries value) {
      validate(fields()[0], value);
      this.scheduleEntriesBuilder = null;
      this.scheduleEntries = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'scheduleEntries' field has been set.
      * @return True if the 'scheduleEntries' field has been set, false otherwise.
      */
    public boolean hasScheduleEntries() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'scheduleEntries' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries.Builder getScheduleEntriesBuilder() {
      if (scheduleEntriesBuilder == null) {
        if (hasScheduleEntries()) {
          setScheduleEntriesBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries.newBuilder(scheduleEntries));
        } else {
          setScheduleEntriesBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries.newBuilder());
        }
      }
      return scheduleEntriesBuilder;
    }

    /**
     * Sets the Builder instance for the 'scheduleEntries' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder setScheduleEntriesBuilder(net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries.Builder value) {
      clearScheduleEntries();
      scheduleEntriesBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'scheduleEntries' field has an active Builder instance
     * @return True if the 'scheduleEntries' field has an active Builder instance
     */
    public boolean hasScheduleEntriesBuilder() {
      return scheduleEntriesBuilder != null;
    }

    /**
      * Clears the value of the 'scheduleEntries' field.
      * @return This builder.
      */
    public net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule.Builder clearScheduleEntries() {
      scheduleEntries = null;
      scheduleEntriesBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public datedSchedule build() {
      try {
        datedSchedule record = new datedSchedule();
        if (scheduleEntriesBuilder != null) {
          try {
            record.scheduleEntries = this.scheduleEntriesBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("scheduleEntries"));
            throw e;
          }
        } else {
          record.scheduleEntries = fieldSetFlags()[0] ? this.scheduleEntries : (net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries) defaultValue(fields()[0]);
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
  private static final org.apache.avro.io.DatumWriter<datedSchedule>
    WRITER$ = (org.apache.avro.io.DatumWriter<datedSchedule>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<datedSchedule>
    READER$ = (org.apache.avro.io.DatumReader<datedSchedule>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    this.scheduleEntries.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (this.scheduleEntries == null) {
        this.scheduleEntries = new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries();
      }
      this.scheduleEntries.customDecode(in);

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (this.scheduleEntries == null) {
            this.scheduleEntries = new net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntries();
          }
          this.scheduleEntries.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










