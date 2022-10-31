package com.github.parasmani300.sampleconsumer.serializer;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import java.util.Map;

public class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer {

    protected final Class<T> targetType;

    public AvroDeserializer(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    public void configure(Map configs, boolean isKey) {
        // do nothing
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        T returnObject = null;

        try {

            if (bytes != null) {
                DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(targetType.newInstance().getSchema());
                Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
                returnObject = (T) datumReader.read(null, decoder);
//                log.info("deserialized data='{}'", returnObject.toString());
                System.out.println("Deserialized Data \n" + returnObject.toString());
            }
        } catch (Exception e) {
//            log.error("Unable to Deserialize bytes[] ", e);
            System.out.println(e);
        }

        return returnObject;
    }

    @Override
    public void close() {
        // do nothing
    }
}