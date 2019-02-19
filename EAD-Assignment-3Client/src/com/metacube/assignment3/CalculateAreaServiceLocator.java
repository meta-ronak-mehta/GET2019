/**
 * CalculateAreaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.assignment3;

public class CalculateAreaServiceLocator extends org.apache.axis.client.Service implements com.metacube.assignment3.CalculateAreaService {

    public CalculateAreaServiceLocator() {
    }


    public CalculateAreaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculateAreaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalculateArea
    private java.lang.String CalculateArea_address = "http://localhost:8080/EAD-Assignment-3/services/CalculateArea";

    public java.lang.String getCalculateAreaAddress() {
        return CalculateArea_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculateAreaWSDDServiceName = "CalculateArea";

    public java.lang.String getCalculateAreaWSDDServiceName() {
        return CalculateAreaWSDDServiceName;
    }

    public void setCalculateAreaWSDDServiceName(java.lang.String name) {
        CalculateAreaWSDDServiceName = name;
    }

    public com.metacube.assignment3.CalculateArea getCalculateArea() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalculateArea_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculateArea(endpoint);
    }

    public com.metacube.assignment3.CalculateArea getCalculateArea(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.assignment3.CalculateAreaSoapBindingStub _stub = new com.metacube.assignment3.CalculateAreaSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalculateAreaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculateAreaEndpointAddress(java.lang.String address) {
        CalculateArea_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.assignment3.CalculateArea.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.assignment3.CalculateAreaSoapBindingStub _stub = new com.metacube.assignment3.CalculateAreaSoapBindingStub(new java.net.URL(CalculateArea_address), this);
                _stub.setPortName(getCalculateAreaWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CalculateArea".equals(inputPortName)) {
            return getCalculateArea();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://assignment3.metacube.com", "CalculateAreaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://assignment3.metacube.com", "CalculateArea"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalculateArea".equals(portName)) {
            setCalculateAreaEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
