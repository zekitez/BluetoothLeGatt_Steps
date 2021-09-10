/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.bluetoothlegatt

import android.bluetooth.BluetoothGattCharacteristic
import java.lang.StringBuilder
import java.util.*

/**
 * This class includes a subset of standard GATT attributes for demonstration purposes.
 *
 */
object SampleGattAttributes {
    private val attributes: HashMap<String?, String?> = HashMap<String?, String?>()

    var HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb"
    var CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb"
    @JvmField
    val SERVICE_UUID = UUID.fromString("ffc2dedc-bf02-442e-a69d-b5caff5e9b21")
    @JvmField
    val CHARACTERISTIC_UUID = UUID.fromString("fbdca8dd-1b1d-4a4c-bc07-040e80c1cb63")
    @JvmField
    val BLE_NOTIFICATION = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")
    var NOTIFY_2AF9 = "00002af9-5348-494d-414e-4f5f424c4500"
    var NOTIFY_2AFB = "00002afb-5348-494d-414e-4f5f424c4500"
    var NOTIFY_2AFD = "00002afd-5348-494d-414e-4f5f424c4500"
    var CHARX_2A26 = "00002a26-0000-1000-8000-00805f9b34fb" // Firmware version
    var CHARX_2A29 = "00002a29-0000-1000-8000-00805f9b34fb" // Manufacturer name
    var CHARX_2AE2 = "00002ae2-1212-efde-1523-785feabcd123"
    var CHARX_2AE3 = "00002ae3-1212-efde-1523-785feabcd123" // MAC address
    var CHARX_2AF3 = "00002af3-5348-494d-414e-4f5f424c4500" // encrypted passkey
    var CHARX_2AF4 = "00002af4-5348-494d-414e-4f5f424c4500" // rollkey
    var CHARX_2AF5 = "00002af5-5348-494d-414e-4f5f424c4500"
    var CHARX_2AF6 = "00002af6-5348-494d-414e-4f5f424c4500"
    var CHARX_2AF7 = "00002af7-5348-494d-414e-4f5f424c4500"
    var CHARX_2AF8 = "00002af8-5348-494d-414e-4f5f424c4500"
    var CHARX_2AFA = "00002afa-5348-494d-414e-4f5f424c4500"
    var CHARX_2AFE = "00002afe-5348-494d-414e-4f5f424c4500" // Destination setting
    var CHARX_2AFF = "00002aff-5348-494d-414e-4f5f424c4500"
    var CHARX_2A19 = "00002a19-0000-1000-8000-00805f9b34fb" // Battery level
    var CHARX_2AC0 = "00002ac0-5348-494d-414e-4f5f424c4500" // Read, but what
    var NOTIFY_2AC1 = "00002ac1-5348-494d-414e-4f5f424c4500" // Drive mode
    var CHARX_2A1A = "00002a1a-0000-1000-8000-00805f9b34fb" // Battery power state
    var CHARX_2A1B = "00002a1b-0000-1000-8000-00805f9b34fb" // Battery power level
    var CHARX_2A00 = "00002a00-0000-1000-8000-00805f9b34fb" // Device name

    @JvmStatic
    fun lookupUuid(uuid: String, defaultName: String): String {
        val name = attributes[uuid.lowercase(Locale.getDefault())]
        return name ?: defaultName
    }

    @JvmStatic
    fun lookupProperties(properties: Int): String {
        val stringBuilder = StringBuilder()
        if (properties and BluetoothGattCharacteristic.PROPERTY_BROADCAST == BluetoothGattCharacteristic.PROPERTY_BROADCAST) {  //
            stringBuilder.append(", Broadcast ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_READ == BluetoothGattCharacteristic.PROPERTY_READ) {   // 2
            stringBuilder.append(", Read ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE == BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE) {  // 4
            stringBuilder.append(", WriteNoResponse ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_WRITE == BluetoothGattCharacteristic.PROPERTY_WRITE) {  // 8
            stringBuilder.append(", Write ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY == BluetoothGattCharacteristic.PROPERTY_NOTIFY) {
            stringBuilder.append(", Notify ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_INDICATE == BluetoothGattCharacteristic.PROPERTY_INDICATE) {
            stringBuilder.append(", Indicate ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE == BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE) {
            stringBuilder.append(", SignedWrite ")
        }
        if (properties and BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS == BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS) {
            stringBuilder.append(", ExtendedProps.")
        }
        return stringBuilder.toString()
    }

    init {
        // Sample Services.
        attributes["0000180a-0000-1000-8000-00805f9b34fb"] = "Shimano Service General"
        attributes["000018ff-5348-494d-414e-4f5f424c4500"] = "Shimano Service UUID1"
        attributes["000018fe-1212-efde-1523-785feabcd123"] = "Shimano Service UUID2 MAC"
        attributes["000018ef-5348-494d-414e-4f5f424c4500"] = "Shimano Service UUID (support mode...)"

        // Sample Characteristics.
        attributes[HEART_RATE_MEASUREMENT] = "Heart Rate Measurement"
        attributes[NOTIFY_2AF9] = "Char. NOTIFY_2AF9"
        attributes[NOTIFY_2AFB] = "Char. NOTIFY_2AFB"
        attributes[NOTIFY_2AFD] = "Char. NOTIFY_2AFD"
        attributes[CHARX_2AE2] = "Char. CHARX_2AE2"
        attributes[CHARX_2AE3] = "Char. CHARX_2AE3 MAC address"
        attributes[CHARX_2AF3] = "Char. CHARX_2AF3 Passkey" // used for encrypted passkey
        attributes[CHARX_2AF4] = "Char. CHARX_2AF4 RollKey" // Possibly a roll-key
        attributes[CHARX_2AF5] = "Char. CHARX_2AF5"
        attributes[CHARX_2AF6] = "Char. CHARX_2AF6"
        attributes[CHARX_2AF7] = "Char. CHARX_2AF7 DisplayName"
        attributes[CHARX_2AF8] = "Char. CHARX_2AF8"
        attributes[CHARX_2AFA] = "Char. CHARX_2AFA request|write Data"
        attributes[CHARX_2AFE] = "Char. CHARX_2AFE request|write Data"
        attributes[CHARX_2AFF] = "Char. CHARX_2AFF"
        attributes[NOTIFY_2AC1] = "Char. NOTIFY_2AC1 Drive mode"

        attributes["a7660001-4b1e-4d6e-91c4-997ba9b6fc07"] = "Renesas Beacon Updater Service"
        attributes["a7660002-4b1e-4d6e-91c4-997ba9b6fc07"] = "Advertising Information"
        attributes["a7660003-4b1e-4d6e-91c4-997ba9b6fc07"] = "Advertising Data"
        attributes["a7660004-4b1e-4d6e-91c4-997ba9b6fc07"] = "Code Flash Memory Updated Count"
        attributes["a7660005-4b1e-4d6e-91c4-997ba9b6fc07"] = "Data Flash Memory Updated Count"
        attributes["a7660006-4b1e-4d6e-91c4-997ba9b6fc07"] = "Scan Response Data"
        attributes["d68c0001-a21b-11e5-8cb8-0002a5d5c51b"] = "Renesas Virtual UART Service"
        attributes["d68c0002-a21b-11e5-8cb8-0002a5d5c51b"] = "Indication Characteristic"
        attributes["d68c0003-a21b-11e5-8cb8-0002a5d5c51b"] = "Write Characteristic"
        attributes["5bc1b9f7-a1f1-40af-9043-c43692c18d7a"] = "Renesas Sample Custom Service"
        attributes["5bc18d80-a1f1-40af-9043-c43692c18d7a"] = "Switch State Characteristic"
        attributes["5bc143ee-a1f1-40af-9043-c43692c18d7a"] = "LED Control Characteristic"
        attributes["64800001-fac7-4b08-afa8-7d89fc4bbb41"] = "Data Exchange Sample Program Service(Tag)"
        attributes["64800002-fac7-4b08-afa8-7d89fc4bbb41"] = "Data Exchange Sample Program Service(Reader)"
        attributes["00001800-0000-1000-8000-00805f9b34fb"] = "Generic access"
        attributes["00001801-0000-1000-8000-00805f9b34fb"] = "Generic attribute"
        attributes["00001802-0000-1000-8000-00805f9b34fb"] = "Immediate alert"
        attributes["00001803-0000-1000-8000-00805f9b34fb"] = "Link loss"
        attributes["00001804-0000-1000-8000-00805f9b34fb"] = "Tx Power"
        attributes["00001805-0000-1000-8000-00805f9b34fb"] = "Current Time Service"
        attributes["00001806-0000-1000-8000-00805f9b34fb"] = "Reference Time Update Service"
        attributes["00001807-0000-1000-8000-00805f9b34fb"] = "Next DST Change Service"
        attributes["00001808-0000-1000-8000-00805f9b34fb"] = "Glucose"
        attributes["00001809-0000-1000-8000-00805f9b34fb"] = "Health Thermometer"
        attributes["0000180a-0000-1000-8000-00805f9b34fb"] = "Device Information Service"
        attributes["0000180b-0000-1000-8000-00805f9b34fb"] = "Network Availability Service"
        attributes["0000180c-0000-1000-8000-00805f9b34fb"] = "Watchdog"
        attributes["0000180d-0000-1000-8000-00805f9b34fb"] = "Heart Rate"
        attributes["0000180e-0000-1000-8000-00805f9b34fb"] = "Phone Alert Status Service"
        attributes["0000180f-0000-1000-8000-00805f9b34fb"] = "Battery Service"
        attributes["00001810-0000-1000-8000-00805f9b34fb"] = "Blood Pressure"
        attributes["00001811-0000-1000-8000-00805f9b34fb"] = "Alert Notification Service"
        attributes["00001812-0000-1000-8000-00805f9b34fb"] = "Human Interface Device"
        attributes["00001813-0000-1000-8000-00805f9b34fb"] = "Scan Parameters"
        attributes["00001814-0000-1000-8000-00805f9b34fb"] = "Running Speed and Cadence"
        attributes["00001815-0000-1000-8000-00805f9b34fb"] = "Automation IO"
        attributes["00001816-0000-1000-8000-00805f9b34fb"] = "Cycling Speed and Cadence"
        attributes["00001818-0000-1000-8000-00805f9b34fb"] = "Cycling Power Service"
        attributes["00001819-0000-1000-8000-00805f9b34fb"] = "Location and Navigation Service"
        attributes["0000181a-0000-1000-8000-00805f9b34fb"] = "Environmental Sensing"
        attributes["0000181b-0000-1000-8000-00805f9b34fb"] = "Body Composision"
        attributes["0000181c-0000-1000-8000-00805f9b34fb"] = "User Data"
        attributes["0000181d-0000-1000-8000-00805f9b34fb"] = "Weight Scale"
        attributes["0000181e-0000-1000-8000-00805f9b34fb"] = "Bond Management"
        attributes["0000181f-0000-1000-8000-00805f9b34fb"] = "Continuous Glucose Measurement Service"
        attributes["00001820-0000-1000-8000-00805f9b34fb"] = "Internet Protocol Support"
        attributes["00001821-0000-1000-8000-00805f9b34fb"] = "Indoor Positioning"
        attributes["00001822-0000-1000-8000-00805f9b34fb"] = "Pulse Oximeter"
        attributes["00001823-0000-1000-8000-00805f9b34fb"] = "HTTP Proxy"
        attributes["00001824-0000-1000-8000-00805f9b34fb"] = "Transport Discovery"
        attributes["00001825-0000-1000-8000-00805f9b34fb"] = "Object Transfer"
        attributes["00002900-0000-1000-8000-00805f9b34fb"] = "Characteristic Extended Properties"
        attributes["00002901-0000-1000-8000-00805f9b34fb"] = "Characteristic User Description"
        attributes["00002902-0000-1000-8000-00805f9b34fb"] = "Client Characteristic Configuration"
        attributes["00002903-0000-1000-8000-00805f9b34fb"] = "Server Characteristic Configuration"
        attributes["00002903-0000-1000-8000-00805f9b34fb"] = "Server Characteristic Configuration"
        attributes["00002904-0000-1000-8000-00805f9b34fb"] = "Characteristic Presentation Format"
        attributes["00002905-0000-1000-8000-00805f9b34fb"] = "Characteristic Aggregate Format"
        attributes["00002906-0000-1000-8000-00805f9b34fb"] = "Valid Range"
        attributes["00002907-0000-1000-8000-00805f9b34fb"] = "External Report Reference"
        attributes["00002908-0000-1000-8000-00805f9b34fb"] = "Report Reference"
        attributes["00002909-0000-1000-8000-00805f9b34fb"] = "Number of Digitals"
        attributes["0000290a-0000-1000-8000-00805f9b34fb"] = "Value Trigger Setting"
        attributes["0000290b-0000-1000-8000-00805f9b34fb"] = "Environmental Sensing Configuration"
        attributes["0000290c-0000-1000-8000-00805f9b34fb"] = "Environmental Sensing Measurement"
        attributes["0000290d-0000-1000-8000-00805f9b34fb"] = "Environmental Sensing Trigger Setting"
        attributes["0000290e-0000-1000-8000-00805f9b34fb"] = "Time Trigger Setting"
        attributes[CHARX_2A00] = "Device Name"
        attributes["00002a01-0000-1000-8000-00805f9b34fb"] = "Appearance"
        attributes["00002a02-0000-1000-8000-00805f9b34fb"] = "Peripheral Privacy Flag"
        attributes["00002a03-0000-1000-8000-00805f9b34fb"] = "Reconnection Address"
        attributes["00002a04-0000-1000-8000-00805f9b34fb"] = "Peripheral Preferred Connection Parameters"
        attributes["00002a05-0000-1000-8000-00805f9b34fb"] = "Service Changed"
        attributes["00002a06-0000-1000-8000-00805f9b34fb"] = "Alert Level"
        attributes["00002a07-0000-1000-8000-00805f9b34fb"] = "Tx Power Level"
        attributes["00002a08-0000-1000-8000-00805f9b34fb"] = "Date Time"
        attributes["00002a09-0000-1000-8000-00805f9b34fb"] = "Day of Week"
        attributes["00002a0a-0000-1000-8000-00805f9b34fb"] = "Day Date Time"
        attributes["00002a0b-0000-1000-8000-00805f9b34fb"] = "Exact Time 100"
        attributes["00002a0c-0000-1000-8000-00805f9b34fb"] = "Exact Time 256"
        attributes["00002a0d-0000-1000-8000-00805f9b34fb"] = "DST Offset"
        attributes["00002a0e-0000-1000-8000-00805f9b34fb"] = "Time Zone"
        attributes["00002a0f-0000-1000-8000-00805f9b34fb"] = "Local Time Information"
        attributes["00002a10-0000-1000-8000-00805f9b34fb"] = "Secondary Time Zone"
        attributes["00002a11-0000-1000-8000-00805f9b34fb"] = "Time with DST"
        attributes["00002a12-0000-1000-8000-00805f9b34fb"] = "Time Accuracy"
        attributes["00002a13-0000-1000-8000-00805f9b34fb"] = "Time Source"
        attributes["00002a14-0000-1000-8000-00805f9b34fb"] = "Reference Time Information"
        attributes["00002a15-0000-1000-8000-00805f9b34fb"] = "Time Broadcast"
        attributes["00002a16-0000-1000-8000-00805f9b34fb"] = "Time Update Control Point"
        attributes["00002a17-0000-1000-8000-00805f9b34fb"] = "Time Update State"
        attributes["00002a18-0000-1000-8000-00805f9b34fb"] = "Glucose Measurement"
        attributes[CHARX_2A19] = "Battery Level"            // "00002a19-0000-1000-8000-00805f9b34fb"
        attributes[CHARX_2A1A] = "Battery Power State"      // "00002a1a-0000-1000-8000-00805f9b34fb"
        attributes[CHARX_2A1B] = "Battery Level State"      // "00002a1b-0000-1000-8000-00805f9b34fb"
        attributes["00002a1c-0000-1000-8000-00805f9b34fb"] = "Temperature Measurement"
        attributes["00002a1d-0000-1000-8000-00805f9b34fb"] = "Temperature Type"
        attributes["00002a1e-0000-1000-8000-00805f9b34fb"] = "Intermediate Temperature"
        attributes["00002a1f-0000-1000-8000-00805f9b34fb"] = "Temperature in Celsius"
        attributes["00002a20-0000-1000-8000-00805f9b34fb"] = "Temperature in Fahrenheit"
        attributes["00002a21-0000-1000-8000-00805f9b34fb"] = "Measurement Interval"
        attributes["00002a22-0000-1000-8000-00805f9b34fb"] = "Boot Keyboard Input Report"
        attributes["00002a23-0000-1000-8000-00805f9b34fb"] = "System ID"
        attributes["00002a24-0000-1000-8000-00805f9b34fb"] = "Model Number String"
        attributes["00002a25-0000-1000-8000-00805f9b34fb"] = "Serial Number String"
        attributes[CHARX_2A26] = "Firmware Revision String" // "00002a26-0000-1000-8000-00805f9b34fb"
        attributes["00002a27-0000-1000-8000-00805f9b34fb"] = "Hardware Revision String"
        attributes["00002a28-0000-1000-8000-00805f9b34fb"] = "Software Revision String"
        attributes[CHARX_2A29] = "Manufacturer Name String" // "00002a29-0000-1000-8000-00805f9b34fb"
        attributes["00002a2a-0000-1000-8000-00805f9b34fb"] = "IEEE 11073-20601 Regulatory Certification Data List"
        attributes["00002a2b-0000-1000-8000-00805f9b34fb"] = "Current Time"
        attributes["00002a2c-0000-1000-8000-00805f9b34fb"] = "Elevation"
        attributes["00002a2d-0000-1000-8000-00805f9b34fb"] = "Latitude"
        attributes["00002a2e-0000-1000-8000-00805f9b34fb"] = "Longitude"
        attributes["00002a2f-0000-1000-8000-00805f9b34fb"] = "Position 2D"
        attributes["00002a30-0000-1000-8000-00805f9b34fb"] = "Position 3D"
        attributes["00002a31-0000-1000-8000-00805f9b34fb"] = "Scan Refresh"
        attributes["00002a32-0000-1000-8000-00805f9b34fb"] = "Boot Keyboard Output Report"
        attributes["00002a33-0000-1000-8000-00805f9b34fb"] = "Boot Mouse Input Report"
        attributes["00002a34-0000-1000-8000-00805f9b34fb"] = "Glucose Measurement Context"
        attributes["00002a35-0000-1000-8000-00805f9b34fb"] = "Blood Pressure Measurement"
        attributes["00002a36-0000-1000-8000-00805f9b34fb"] = "Intermediate Cuff Pressure"
        attributes["00002a37-0000-1000-8000-00805f9b34fb"] = "Heart Rate Measurement"
        attributes["00002a38-0000-1000-8000-00805f9b34fb"] = "Body Sensor Location"
        attributes["00002a39-0000-1000-8000-00805f9b34fb"] = "Heart Rate Control Point"
        attributes["00002a3a-0000-1000-8000-00805f9b34fb"] = "Removable"
        attributes["00002a3b-0000-1000-8000-00805f9b34fb"] = "Service Required"
        attributes["00002a3c-0000-1000-8000-00805f9b34fb"] = "Scientific Temperature in Celsius"
        attributes["00002a3d-0000-1000-8000-00805f9b34fb"] = "String"
        attributes["00002a3e-0000-1000-8000-00805f9b34fb"] = "Network Availability"
        attributes["00002a3f-0000-1000-8000-00805f9b34fb"] = "Alert Status"
        attributes["00002a40-0000-1000-8000-00805f9b34fb"] = "Ringer Control Point"
        attributes["00002a41-0000-1000-8000-00805f9b34fb"] = "Ringer Setting"
        attributes["00002a42-0000-1000-8000-00805f9b34fb"] = "Alert Category ID Bit Mask"
        attributes["00002a43-0000-1000-8000-00805f9b34fb"] = "Alert Category ID"
        attributes["00002a44-0000-1000-8000-00805f9b34fb"] = "Alert Notification Control Point"
        attributes["00002a45-0000-1000-8000-00805f9b34fb"] = "Unread Alert Status"
        attributes["00002a46-0000-1000-8000-00805f9b34fb"] = "New Alert"
        attributes["00002a47-0000-1000-8000-00805f9b34fb"] = "Supported New Alert Category"
        attributes["00002a48-0000-1000-8000-00805f9b34fb"] = "Supported Unread Alert Category"
        attributes["00002a49-0000-1000-8000-00805f9b34fb"] = "Blood Pressure Feature"
        attributes["00002a4a-0000-1000-8000-00805f9b34fb"] = "HID Information"
        attributes["00002a4b-0000-1000-8000-00805f9b34fb"] = "Report Map"
        attributes["00002a4c-0000-1000-8000-00805f9b34fb"] = "HID Control Point"
        attributes["00002a4d-0000-1000-8000-00805f9b34fb"] = "Report"
        attributes["00002a4e-0000-1000-8000-00805f9b34fb"] = "Protocol Mode"
        attributes["00002a4f-0000-1000-8000-00805f9b34fb"] = "Scan Interval Window"
        attributes["00002a50-0000-1000-8000-00805f9b34fb"] = "PnP ID"
        attributes["00002a51-0000-1000-8000-00805f9b34fb"] = "Glucose Features"
        attributes["00002a52-0000-1000-8000-00805f9b34fb"] = "Record Access Control Point"
        attributes["00002a53-0000-1000-8000-00805f9b34fb"] = "RSC Measurement"
        attributes["00002a54-0000-1000-8000-00805f9b34fb"] = "RSC Feature"
        attributes["00002a55-0000-1000-8000-00805f9b34fb"] = "SC Control Point"
        attributes["00002a56-0000-1000-8000-00805f9b34fb"] = "Digital Input"
        attributes["00002a57-0000-1000-8000-00805f9b34fb"] = "Digital Output"
        attributes["00002a58-0000-1000-8000-00805f9b34fb"] = "Analog Input"
        attributes["00002a59-0000-1000-8000-00805f9b34fb"] = "Analog Output"
        attributes["00002a5a-0000-1000-8000-00805f9b34fb"] = "Aggregate Input"
        attributes["00002a5b-0000-1000-8000-00805f9b34fb"] = "CSC Measurement"
        attributes["00002a5c-0000-1000-8000-00805f9b34fb"] = "CSC Feature"
        attributes["00002a5d-0000-1000-8000-00805f9b34fb"] = "Sensor Location"
        attributes["00002a5e-0000-1000-8000-00805f9b34fb"] = "Pulse Oximetry Spot-check Measurement"
        attributes["00002a5f-0000-1000-8000-00805f9b34fb"] = "Pulse Oximetry Continuous Measurement"
        attributes["00002a60-0000-1000-8000-00805f9b34fb"] = "Pulse Oximetry Pulsatile Event"
        attributes["00002a61-0000-1000-8000-00805f9b34fb"] = "Pulse Oximetry Features"
        attributes["00002a62-0000-1000-8000-00805f9b34fb"] = "Pulse Oximetry Control Point"
        attributes["00002a63-0000-1000-8000-00805f9b34fb"] = "Cycling Power Measurement Characteristic"
        attributes["00002a64-0000-1000-8000-00805f9b34fb"] = "Cycling Power Vector Characteristic"
        attributes["00002a65-0000-1000-8000-00805f9b34fb"] = "Cycling Power Feature Characteristic"
        attributes["00002a66-0000-1000-8000-00805f9b34fb"] = "Cycling Power Control Point Characteristic"
        attributes["00002a67-0000-1000-8000-00805f9b34fb"] = "Location and Speed Characteristic"
        attributes["00002a68-0000-1000-8000-00805f9b34fb"] = "Navigation Characteristic"
        attributes["00002a69-0000-1000-8000-00805f9b34fb"] = "Position Quality Characteristic"
        attributes["00002a6a-0000-1000-8000-00805f9b34fb"] = "LN Feature Characteristic"
        attributes["00002a6b-0000-1000-8000-00805f9b34fb"] = "LN Control Point Characteristic"
        attributes["00002a6c-0000-1000-8000-00805f9b34fb"] = "CGM Measurement Characteristic"
        attributes["00002a6d-0000-1000-8000-00805f9b34fb"] = "CGM Features Characteristic"
        attributes["00002a6e-0000-1000-8000-00805f9b34fb"] = "CGM Status Characteristic"
        attributes["00002a6f-0000-1000-8000-00805f9b34fb"] = "CGM Session Start Time Characteristic"
        attributes["00002a70-0000-1000-8000-00805f9b34fb"] = "Application Security Point Characteristic"
        attributes["00002a71-0000-1000-8000-00805f9b34fb"] = "CGM Specific Ops Control Point Characteristic"
        attributes["00002a72-0000-1000-8000-00805f9b34fb"] = "Apparent Wind Speed"
        attributes["00002a73-0000-1000-8000-00805f9b34fb"] = "Apparent Wind Direction"
        attributes["00002a74-0000-1000-8000-00805f9b34fb"] = "Gust Factor"
        attributes["00002a75-0000-1000-8000-00805f9b34fb"] = "Pollen Concentration"
        attributes["00002a76-0000-1000-8000-00805f9b34fb"] = "UV Index"
        attributes["00002a77-0000-1000-8000-00805f9b34fb"] = "Irradiance"
        attributes["00002a78-0000-1000-8000-00805f9b34fb"] = "Rainfall"
        attributes["00002a79-0000-1000-8000-00805f9b34fb"] = "Wind Chill"
        attributes["00002a7a-0000-1000-8000-00805f9b34fb"] = "Heat Index"
        attributes["00002a7b-0000-1000-8000-00805f9b34fb"] = "Dew Point"
        attributes["00002a7d-0000-1000-8000-00805f9b34fb"] = "Descriptor Value Changed"
        attributes["00002a7e-0000-1000-8000-00805f9b34fb"] = "Aerobic Heart Rate Lower Limit"
        attributes["00002a7f-0000-1000-8000-00805f9b34fb"] = "Aerobic Threshold"
        attributes["00002a80-0000-1000-8000-00805f9b34fb"] = "Age"
        attributes["00002a81-0000-1000-8000-00805f9b34fb"] = "Anaerobic Heart Rate Lower Limit"
        attributes["00002a82-0000-1000-8000-00805f9b34fb"] = "Anaerobic Heart Rate Upper Limit"
        attributes["00002a83-0000-1000-8000-00805f9b34fb"] = "Anaerobic Threshold"
        attributes["00002a84-0000-1000-8000-00805f9b34fb"] = "Aerobic Heart Rate Upper Limit"
        attributes["00002a85-0000-1000-8000-00805f9b34fb"] = "Date of Birth"
        attributes["00002a86-0000-1000-8000-00805f9b34fb"] = "Date of Threshold Assessment"
        attributes["00002a87-0000-1000-8000-00805f9b34fb"] = "Email Address"
        attributes["00002a88-0000-1000-8000-00805f9b34fb"] = "Fat Burn Heart Rate Lower Limit"
        attributes["00002a89-0000-1000-8000-00805f9b34fb"] = "Fat Burn Heart Rate Upper Limit"
        attributes["00002a8a-0000-1000-8000-00805f9b34fb"] = "First Name"
        attributes["00002a8b-0000-1000-8000-00805f9b34fb"] = "Five Zone Heart Rate Limits"
        attributes["00002a8c-0000-1000-8000-00805f9b34fb"] = "Gender"
        attributes["00002a8d-0000-1000-8000-00805f9b34fb"] = "Heart Rate Max"
        attributes["00002a8e-0000-1000-8000-00805f9b34fb"] = "Height"
        attributes["00002a8f-0000-1000-8000-00805f9b34fb"] = "Hip Circumference"
        attributes["00002a90-0000-1000-8000-00805f9b34fb"] = "Last Name"
        attributes["00002a91-0000-1000-8000-00805f9b34fb"] = "Maximum Recommended Heart Rate"
        attributes["00002a92-0000-1000-8000-00805f9b34fb"] = "Resting Heart Rate"
        attributes["00002a93-0000-1000-8000-00805f9b34fb"] = "Sport Type for Aerobic and Anaerobic Thresholds"
        attributes["00002a94-0000-1000-8000-00805f9b34fb"] = "Three Zone Heart Rate Limits"
        attributes["00002a95-0000-1000-8000-00805f9b34fb"] = "Two Zone Heart Rate Limit"
        attributes["00002a96-0000-1000-8000-00805f9b34fb"] = "VO2 Max"
        attributes["00002a97-0000-1000-8000-00805f9b34fb"] = "Waist Circumference"
        attributes["00002a98-0000-1000-8000-00805f9b34fb"] = "Weight"
        attributes["00002a99-0000-1000-8000-00805f9b34fb"] = "Database Change Increment"
        attributes["00002a9a-0000-1000-8000-00805f9b34fb"] = "User Index"
        attributes["00002a9b-0000-1000-8000-00805f9b34fb"] = "Body Composition Feature"
        attributes["00002a9c-0000-1000-8000-00805f9b34fb"] = "Body Composition Measurement"
        attributes["00002a9d-0000-1000-8000-00805f9b34fb"] = "Weight Measurement"
        attributes["00002a9e-0000-1000-8000-00805f9b34fb"] = "Weight Scale Feature"
        attributes["00002a9f-0000-1000-8000-00805f9b34fb"] = "User Control Point"
        attributes["00002aa0-0000-1000-8000-00805f9b34fb"] = "Magnetic Flux Density - 2D"
        attributes["00002aa1-0000-1000-8000-00805f9b34fb"] = "Magnetic Flux Density - 3D"
        attributes["00002aa2-0000-1000-8000-00805f9b34fb"] = "Language"
        attributes["00002aa3-0000-1000-8000-00805f9b34fb"] = "Barometric Pressure Trend"
        attributes["00002aa4-0000-1000-8000-00805f9b34fb"] = "Bond Management Control Point"
        attributes["00002aa5-0000-1000-8000-00805f9b34fb"] = "Bond Management Feature"
        attributes["00002aa6-0000-1000-8000-00805f9b34fb"] = "Central Address Resolution"
        attributes["00002aa7-0000-1000-8000-00805f9b34fb"] = "CGM Measurement"
        attributes["00002aa8-0000-1000-8000-00805f9b34fb"] = "CGM Feature"
        attributes["00002aa9-0000-1000-8000-00805f9b34fb"] = "CGM Status"
        attributes["00002aaa-0000-1000-8000-00805f9b34fb"] = "CGM Session Start Time"
        attributes["00002aab-0000-1000-8000-00805f9b34fb"] = "CGM Session Run Time"
        attributes["00002aac-0000-1000-8000-00805f9b34fb"] = "CGM Specific Ops Control Point"
        attributes["00002aad-0000-1000-8000-00805f9b34fb"] = "Indoor Positioning Configuration"
        attributes["00002aae-0000-1000-8000-00805f9b34fb"] = "Latitude"
        attributes["00002aaf-0000-1000-8000-00805f9b34fb"] = "Longitude"
        attributes["00002ab0-0000-1000-8000-00805f9b34fb"] = "Local North Coordinate"
        attributes["00002ab1-0000-1000-8000-00805f9b34fb"] = "Local East Coordinate"
        attributes["00002ab2-0000-1000-8000-00805f9b34fb"] = "Floor Number"
        attributes["00002ab3-0000-1000-8000-00805f9b34fb"] = "Altitude"
        attributes["00002ab4-0000-1000-8000-00805f9b34fb"] = "Uncertainty"
        attributes["00002ab5-0000-1000-8000-00805f9b34fb"] = "Location Name"
        attributes["00002ab6-0000-1000-8000-00805f9b34fb"] = "URI"
        attributes["00002ab7-0000-1000-8000-00805f9b34fb"] = "HTTP Headers"
        attributes["00002ab8-0000-1000-8000-00805f9b34fb"] = "HTTP Status Code"
        attributes["00002ab9-0000-1000-8000-00805f9b34fb"] = "HTTP Entity Body"
        attributes["00002aba-0000-1000-8000-00805f9b34fb"] = "HTTP Control Point"
        attributes["00002abb-0000-1000-8000-00805f9b34fb"] = "HTTPS Security"
        attributes["00002abc-0000-1000-8000-00805f9b34fb"] = "TDS Control Point"
        attributes["00002abd-0000-1000-8000-00805f9b34fb"] = "OTS Feature"
        attributes["00002abe-0000-1000-8000-00805f9b34fb"] = "Object Name"
        attributes["00002abf-0000-1000-8000-00805f9b34fb"] = "Object Type"
        attributes["00002ac0-0000-1000-8000-00805f9b34fb"] = "Object Size"
        attributes["00002ac1-0000-1000-8000-00805f9b34fb"] = "Object First-Created"
        attributes["00002ac2-0000-1000-8000-00805f9b34fb"] = "Object Last-Modified"
        attributes["00002ac3-0000-1000-8000-00805f9b34fb"] = "Object ID"
        attributes["00002ac4-0000-1000-8000-00805f9b34fb"] = "Object Properties"
        attributes["00002ac5-0000-1000-8000-00805f9b34fb"] = "Object Action Control Point"
        attributes["00002ac6-0000-1000-8000-00805f9b34fb"] = "Object List Control Point"
        attributes["00002ac7-0000-1000-8000-00805f9b34fb"] = "Object List Filter"
        attributes["00002ac8-0000-1000-8000-00805f9b34fb"] = "Object Changed"
        attributes["00002ac9-0000-1000-8000-00805f9b34fb"] = "Resolvable Private Address Only"
    }
}