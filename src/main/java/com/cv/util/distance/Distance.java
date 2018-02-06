/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.cv.util.distance;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-07-01")
public class Distance {

  public interface Iface {

    public QueryResult doQuery(String queryWordKey) throws CustomRuntimeException, org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void doQuery(String queryWordKey, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public QueryResult doQuery(String queryWordKey) throws CustomRuntimeException, org.apache.thrift.TException
    {
      send_doQuery(queryWordKey);
      return recv_doQuery();
    }

    public void send_doQuery(String queryWordKey) throws org.apache.thrift.TException
    {
      doQuery_args args = new doQuery_args();
      args.setQueryWordKey(queryWordKey);
      sendBase("doQuery", args);
    }

    public QueryResult recv_doQuery() throws CustomRuntimeException, org.apache.thrift.TException
    {
      doQuery_result result = new doQuery_result();
      receiveBase(result, "doQuery");
      if (result.isSetSuccess()) {
        return result.success;
      }
      if (result.cre != null) {
        throw result.cre;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "doQuery failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void doQuery(String queryWordKey, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
      checkReady();
      doQuery_call method_call = new doQuery_call(queryWordKey, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class doQuery_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String queryWordKey;
      public doQuery_call(String queryWordKey, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.queryWordKey = queryWordKey;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("doQuery", org.apache.thrift.protocol.TMessageType.CALL, 0));
        doQuery_args args = new doQuery_args();
        args.setQueryWordKey(queryWordKey);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public QueryResult getResult() throws CustomRuntimeException, org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_doQuery();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("doQuery", new doQuery());
      return processMap;
    }

    public static class doQuery<I extends Iface> extends org.apache.thrift.ProcessFunction<I, doQuery_args> {
      public doQuery() {
        super("doQuery");
      }

      public doQuery_args getEmptyArgsInstance() {
        return new doQuery_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public doQuery_result getResult(I iface, doQuery_args args) throws org.apache.thrift.TException {
        doQuery_result result = new doQuery_result();
        try {
          result.success = iface.doQuery(args.queryWordKey);
        } catch (CustomRuntimeException cre) {
          result.cre = cre;
        }
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("doQuery", new doQuery());
      return processMap;
    }

    public static class doQuery<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, doQuery_args, QueryResult> {
      public doQuery() {
        super("doQuery");
      }

      public doQuery_args getEmptyArgsInstance() {
        return new doQuery_args();
      }

      public AsyncMethodCallback<QueryResult> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<QueryResult>() { 
          public void onComplete(QueryResult o) {
            doQuery_result result = new doQuery_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            doQuery_result result = new doQuery_result();
            if (e instanceof CustomRuntimeException) {
                        result.cre = (CustomRuntimeException) e;
                        result.setCreIsSet(true);
                        msg = result;
            }
             else 
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, doQuery_args args, org.apache.thrift.async.AsyncMethodCallback<QueryResult> resultHandler) throws TException {
        iface.doQuery(args.queryWordKey,resultHandler);
      }
    }

  }

  public static class doQuery_args implements org.apache.thrift.TBase<doQuery_args, doQuery_args._Fields>, java.io.Serializable, Cloneable, Comparable<doQuery_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("doQuery_args");

    private static final org.apache.thrift.protocol.TField QUERY_WORD_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("queryWordKey", org.apache.thrift.protocol.TType.STRING, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new doQuery_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new doQuery_argsTupleSchemeFactory());
    }

    public String queryWordKey; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      QUERY_WORD_KEY((short)1, "queryWordKey");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // QUERY_WORD_KEY
            return QUERY_WORD_KEY;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.QUERY_WORD_KEY, new org.apache.thrift.meta_data.FieldMetaData("queryWordKey", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(doQuery_args.class, metaDataMap);
    }

    public doQuery_args() {
    }

    public doQuery_args(
      String queryWordKey)
    {
      this();
      this.queryWordKey = queryWordKey;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public doQuery_args(doQuery_args other) {
      if (other.isSetQueryWordKey()) {
        this.queryWordKey = other.queryWordKey;
      }
    }

    public doQuery_args deepCopy() {
      return new doQuery_args(this);
    }

    @Override
    public void clear() {
      this.queryWordKey = null;
    }

    public String getQueryWordKey() {
      return this.queryWordKey;
    }

    public doQuery_args setQueryWordKey(String queryWordKey) {
      this.queryWordKey = queryWordKey;
      return this;
    }

    public void unsetQueryWordKey() {
      this.queryWordKey = null;
    }

    /** Returns true if field queryWordKey is set (has been assigned a value) and false otherwise */
    public boolean isSetQueryWordKey() {
      return this.queryWordKey != null;
    }

    public void setQueryWordKeyIsSet(boolean value) {
      if (!value) {
        this.queryWordKey = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case QUERY_WORD_KEY:
        if (value == null) {
          unsetQueryWordKey();
        } else {
          setQueryWordKey((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case QUERY_WORD_KEY:
        return getQueryWordKey();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case QUERY_WORD_KEY:
        return isSetQueryWordKey();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof doQuery_args)
        return this.equals((doQuery_args)that);
      return false;
    }

    public boolean equals(doQuery_args that) {
      if (that == null)
        return false;

      boolean this_present_queryWordKey = true && this.isSetQueryWordKey();
      boolean that_present_queryWordKey = true && that.isSetQueryWordKey();
      if (this_present_queryWordKey || that_present_queryWordKey) {
        if (!(this_present_queryWordKey && that_present_queryWordKey))
          return false;
        if (!this.queryWordKey.equals(that.queryWordKey))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_queryWordKey = true && (isSetQueryWordKey());
      list.add(present_queryWordKey);
      if (present_queryWordKey)
        list.add(queryWordKey);

      return list.hashCode();
    }

    @Override
    public int compareTo(doQuery_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetQueryWordKey()).compareTo(other.isSetQueryWordKey());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetQueryWordKey()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queryWordKey, other.queryWordKey);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("doQuery_args(");
      boolean first = true;

      sb.append("queryWordKey:");
      if (this.queryWordKey == null) {
        sb.append("null");
      } else {
        sb.append(this.queryWordKey);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class doQuery_argsStandardSchemeFactory implements SchemeFactory {
      public doQuery_argsStandardScheme getScheme() {
        return new doQuery_argsStandardScheme();
      }
    }

    private static class doQuery_argsStandardScheme extends StandardScheme<doQuery_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, doQuery_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // QUERY_WORD_KEY
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.queryWordKey = iprot.readString();
                struct.setQueryWordKeyIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, doQuery_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.queryWordKey != null) {
          oprot.writeFieldBegin(QUERY_WORD_KEY_FIELD_DESC);
          oprot.writeString(struct.queryWordKey);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class doQuery_argsTupleSchemeFactory implements SchemeFactory {
      public doQuery_argsTupleScheme getScheme() {
        return new doQuery_argsTupleScheme();
      }
    }

    private static class doQuery_argsTupleScheme extends TupleScheme<doQuery_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, doQuery_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetQueryWordKey()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetQueryWordKey()) {
          oprot.writeString(struct.queryWordKey);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, doQuery_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.queryWordKey = iprot.readString();
          struct.setQueryWordKeyIsSet(true);
        }
      }
    }

  }

  public static class doQuery_result implements org.apache.thrift.TBase<doQuery_result, doQuery_result._Fields>, java.io.Serializable, Cloneable, Comparable<doQuery_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("doQuery_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);
    private static final org.apache.thrift.protocol.TField CRE_FIELD_DESC = new org.apache.thrift.protocol.TField("cre", org.apache.thrift.protocol.TType.STRUCT, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new doQuery_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new doQuery_resultTupleSchemeFactory());
    }

    public QueryResult success; // required
    public CustomRuntimeException cre; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success"),
      CRE((short)1, "cre");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          case 1: // CRE
            return CRE;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, QueryResult.class)));
      tmpMap.put(_Fields.CRE, new org.apache.thrift.meta_data.FieldMetaData("cre", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(doQuery_result.class, metaDataMap);
    }

    public doQuery_result() {
    }

    public doQuery_result(
      QueryResult success,
      CustomRuntimeException cre)
    {
      this();
      this.success = success;
      this.cre = cre;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public doQuery_result(doQuery_result other) {
      if (other.isSetSuccess()) {
        this.success = new QueryResult(other.success);
      }
      if (other.isSetCre()) {
        this.cre = new CustomRuntimeException(other.cre);
      }
    }

    public doQuery_result deepCopy() {
      return new doQuery_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
      this.cre = null;
    }

    public QueryResult getSuccess() {
      return this.success;
    }

    public doQuery_result setSuccess(QueryResult success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public CustomRuntimeException getCre() {
      return this.cre;
    }

    public doQuery_result setCre(CustomRuntimeException cre) {
      this.cre = cre;
      return this;
    }

    public void unsetCre() {
      this.cre = null;
    }

    /** Returns true if field cre is set (has been assigned a value) and false otherwise */
    public boolean isSetCre() {
      return this.cre != null;
    }

    public void setCreIsSet(boolean value) {
      if (!value) {
        this.cre = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((QueryResult)value);
        }
        break;

      case CRE:
        if (value == null) {
          unsetCre();
        } else {
          setCre((CustomRuntimeException)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      case CRE:
        return getCre();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      case CRE:
        return isSetCre();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof doQuery_result)
        return this.equals((doQuery_result)that);
      return false;
    }

    public boolean equals(doQuery_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      boolean this_present_cre = true && this.isSetCre();
      boolean that_present_cre = true && that.isSetCre();
      if (this_present_cre || that_present_cre) {
        if (!(this_present_cre && that_present_cre))
          return false;
        if (!this.cre.equals(that.cre))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_success = true && (isSetSuccess());
      list.add(present_success);
      if (present_success)
        list.add(success);

      boolean present_cre = true && (isSetCre());
      list.add(present_cre);
      if (present_cre)
        list.add(cre);

      return list.hashCode();
    }

    @Override
    public int compareTo(doQuery_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetCre()).compareTo(other.isSetCre());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetCre()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cre, other.cre);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("doQuery_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("cre:");
      if (this.cre == null) {
        sb.append("null");
      } else {
        sb.append(this.cre);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
      if (success != null) {
        success.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class doQuery_resultStandardSchemeFactory implements SchemeFactory {
      public doQuery_resultStandardScheme getScheme() {
        return new doQuery_resultStandardScheme();
      }
    }

    private static class doQuery_resultStandardScheme extends StandardScheme<doQuery_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, doQuery_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.success = new QueryResult();
                struct.success.read(iprot);
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 1: // CRE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.cre = new CustomRuntimeException();
                struct.cre.read(iprot);
                struct.setCreIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, doQuery_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        if (struct.cre != null) {
          oprot.writeFieldBegin(CRE_FIELD_DESC);
          struct.cre.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class doQuery_resultTupleSchemeFactory implements SchemeFactory {
      public doQuery_resultTupleScheme getScheme() {
        return new doQuery_resultTupleScheme();
      }
    }

    private static class doQuery_resultTupleScheme extends TupleScheme<doQuery_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, doQuery_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        if (struct.isSetCre()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetSuccess()) {
          struct.success.write(oprot);
        }
        if (struct.isSetCre()) {
          struct.cre.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, doQuery_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.success = new QueryResult();
          struct.success.read(iprot);
          struct.setSuccessIsSet(true);
        }
        if (incoming.get(1)) {
          struct.cre = new CustomRuntimeException();
          struct.cre.read(iprot);
          struct.setCreIsSet(true);
        }
      }
    }

  }

}