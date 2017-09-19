package com.rfchina.internet.mytestapp.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luoyican on 2017/8/29.
 */

public class AliRecognitionEntityWrapper implements Serializable {
    private java.util.List<OutputsBean> outputs;

    public List<OutputsBean> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<OutputsBean> outputs) {
        this.outputs = outputs;
    }

    public static class OutputsBean implements Serializable {
        private String outputLabel;
        private OutputValueBean outputValue;

        public String getOutputLabel() {
            return outputLabel;
        }

        public void setOutputLabel(String outputLabel) {
            this.outputLabel = outputLabel;
        }

        public OutputValueBean getOutputValue() {
            return outputValue;
        }

        public void setOutputValue(OutputValueBean outputValue) {
            this.outputValue = outputValue;
        }

        public static class OutputValueBean implements Serializable {
            private int dataType;
            private String dataValue;

            public int getDataType() {
                return dataType;
            }

            public void setDataType(int dataType) {
                this.dataType = dataType;
            }

            public String getDataValue() {
                return dataValue;
            }

            public void setDataValue(String dataValue) {
                this.dataValue = dataValue;
            }

            public static class DataValueBean implements Serializable {
                private String card_num;
                private String request_id;
                private boolean success;

                public String getCard_num() {
                    return card_num;
                }

                public void setCard_num(String card_num) {
                    this.card_num = card_num;
                }

                public String getRequest_id() {
                    return request_id;
                }

                public void setRequest_id(String request_id) {
                    this.request_id = request_id;
                }

                public boolean isSuccess() {
                    return success;
                }

                public void setSuccess(boolean success) {
                    this.success = success;
                }
            }
        }
    }

}
