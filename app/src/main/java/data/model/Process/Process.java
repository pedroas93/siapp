package data.model.Process;

/**
 * Created by pedroas93 on 19/10/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Process {


        @SerializedName("documentos")
        @Expose
        private List<Documento> documentos = null;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("valor")
        @Expose
        private Integer valor;
        @SerializedName("pedido")
        @Expose
        private String pedido;
        @SerializedName("__v")
        @Expose
        private Integer v;
        @SerializedName("vistosBuenos")
        @Expose
        private List<VistosBueno> vistosBuenos = null;
        @SerializedName("monedaOrigen")
        @Expose
        private String monedaOrigen;
        @SerializedName("fechaApertura")
        @Expose
        private String fechaApertura;
        @SerializedName("bultos")
        @Expose
        private Integer bultos;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("processId")
        @Expose
        private String processId;
        @SerializedName("agent")
        @Expose
        private Agent agent;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("client")
        @Expose
        private Client client;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("guiaAereaMaritima")
        @Expose
        private String guiaAereaMaritima;
        @SerializedName("factura")
        @Expose
        private String factura;
        @SerializedName("steps")
        @Expose
        private Steps steps;
        @SerializedName("tipoDeCambio")
        @Expose
        private Integer tipoDeCambio;

        public List<Documento> getDocumentos() {
            return documentos;
        }

        public void setDocumentos(List<Documento> documentos) {
            this.documentos = documentos;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getValor() {
            return valor;
        }

        public void setValor(Integer valor) {
            this.valor = valor;
        }

        public void setPedido(String valor) {
        this.pedido = valor;
    }

        public String getPedido() {
            return pedido;
        }


        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

        public List<VistosBueno> getVistosBuenos() {
            return vistosBuenos;
        }

        public void setVistosBuenos(List<VistosBueno> vistosBuenos) {
            this.vistosBuenos = vistosBuenos;
        }

        public String getMonedaOrigen() {
            return monedaOrigen;
        }

        public void setMonedaOrigen(String monedaOrigen) {
            this.monedaOrigen = monedaOrigen;
        }

        public String getFechaApertura() {
            return fechaApertura;
        }

        public void setFechaApertura(String fechaApertura) {
            this.fechaApertura = fechaApertura;
        }

        public Integer getBultos() {
            return bultos;
        }

        public void setBultos(Integer bultos) {
            this.bultos = bultos;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProcessId() {
            return processId;
        }

        public void setProcessId(String processId) {
            this.processId = processId;
        }

        public Agent getAgent() {
            return agent;
        }

        public void setAgent(Agent agent) {
            this.agent = agent;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getGuiaAereaMaritima() {
            return guiaAereaMaritima;
        }

        public void setGuiaAereaMaritima(String guiaAereaMaritima) {
            this.guiaAereaMaritima = guiaAereaMaritima;
        }

        public String getFactura() {
            return factura;
        }

        public void setFactura(String factura) {
            this.factura = factura;
        }

        public Steps getSteps() {
            return steps;
        }

        public void setSteps(Steps steps) {
            this.steps = steps;
        }

        public Integer getTipoDeCambio() {
            return tipoDeCambio;
        }

        public void setTipoDeCambio(Integer tipoDeCambio) {
            this.tipoDeCambio = tipoDeCambio;
        }

    @Override
    public String toString() {
        return "Process{" +
                ", documentos=" + documentos + '\'' +
                ", status=" + status + '\'' +
                ", valor=" + valor + '\'' +
                ", type=" + type + '\'' +
                ", pedido=" + pedido + '\'' +
                ", vistosBuenos=" + vistosBuenos + '\'' +
                ", monedaOrigen=" + monedaOrigen + '\'' +
                ", fechaApertura=" + fechaApertura + '\'' +
                ", tipo de cambio=" + tipoDeCambio + '\'' +

                '}';
    }


}