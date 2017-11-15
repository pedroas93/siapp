package data.model.Process;

/**
 * Created by pedroas93 on 19/10/17.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Steps {

    @SerializedName("fechaSalidaMercancia")
    @Expose
    private FechaSalidaMercancia fechaSalidaMercancia;
    @SerializedName("entregaAerolinea")
    @Expose
    private EntregaAerolinea entregaAerolinea;
    @SerializedName("generacionVistosBuenos")
    @Expose
    private List<GeneracionVistosBueno> generacionVistosBuenos = null;
    @SerializedName("solicitudSelectividadDocTransporte")
    @Expose
    private SolicitudSelectividadDocTransporte solicitudSelectividadDocTransporte;
    @SerializedName("entregaDeDocumentos")
    @Expose
    private EntregaDeDocumentos entregaDeDocumentos;
    @SerializedName("recepcionDeDocumentos")
    @Expose
    private RecepcionDeDocumentos recepcionDeDocumentos;
    @SerializedName("elaboracionDocExportacion")
    @Expose
    private ElaboracionDocExportacion elaboracionDocExportacion;
    @SerializedName("retiroDeMercancias")
    @Expose
    private RetiroDeMercancias retiroDeMercancias;
    @SerializedName("preinspeccion")
    @Expose
    private Preinspeccion preinspeccion;
    @SerializedName("levante")
    @Expose
    private Levante levante;
    @SerializedName("entregaDeMercancia")
    @Expose
    private EntregaDeMercancia entregaDeMercancia;
    @SerializedName("validacionDocumentos")
    @Expose
    private List<ValidacionDocumento> validacionDocumentos = null;
    @SerializedName("anticipoAGirar")
    @Expose
    private AnticipoAGirar anticipoAGirar;
    @SerializedName("arriboDeMercancia")
    @Expose
    private ArriboDeMercancia arriboDeMercancia;
    @SerializedName("pagoDeTributos")
    @Expose
    private PagoDeTributos pagoDeTributos;
    @SerializedName("liberacionDeDocDeTransporte")
    @Expose
    private LiberacionDeDocDeTransporte liberacionDeDocDeTransporte;
    @SerializedName("elaboracionDeDocDeImportacion")
    @Expose
    private List<ElaboracionDeDocDeImportacion> elaboracionDeDocDeImportacion = null;
    @SerializedName("validacionVistosBuenos")
    @Expose
    private List<ValidacionVistosBueno> validacionVistosBuenos = null;

    public FechaSalidaMercancia getFechaSalidaMercancia() {
        return fechaSalidaMercancia;
    }

    public void setFechaSalidaMercancia(FechaSalidaMercancia fechaSalidaMercancia) {
        this.fechaSalidaMercancia = fechaSalidaMercancia;
    }

    public EntregaAerolinea getEntregaAerolinea() {
        return entregaAerolinea;
    }

    public void setEntregaAerolinea(EntregaAerolinea entregaAerolinea) {
        this.entregaAerolinea = entregaAerolinea;
    }

    public List<GeneracionVistosBueno> getGeneracionVistosBuenos() {
        return generacionVistosBuenos;
    }

    public void setGeneracionVistosBuenos(List<GeneracionVistosBueno> generacionVistosBuenos) {
        this.generacionVistosBuenos = generacionVistosBuenos;
    }

    public SolicitudSelectividadDocTransporte getSolicitudSelectividadDocTransporte() {
        return solicitudSelectividadDocTransporte;
    }

    public void setSolicitudSelectividadDocTransporte(SolicitudSelectividadDocTransporte solicitudSelectividadDocTransporte) {
        this.solicitudSelectividadDocTransporte = solicitudSelectividadDocTransporte;
    }

    public EntregaDeDocumentos getEntregaDeDocumentos() {
        return entregaDeDocumentos;
    }

    public void setEntregaDeDocumentos(EntregaDeDocumentos entregaDeDocumentos) {
        this.entregaDeDocumentos = entregaDeDocumentos;
    }

    public RecepcionDeDocumentos getRecepcionDeDocumentos() {
        return recepcionDeDocumentos;
    }

    public void setRecepcionDeDocumentos(RecepcionDeDocumentos recepcionDeDocumentos) {
        this.recepcionDeDocumentos = recepcionDeDocumentos;
    }

    public ElaboracionDocExportacion getElaboracionDocExportacion() {
        return elaboracionDocExportacion;
    }

    public void setElaboracionDocExportacion(ElaboracionDocExportacion elaboracionDocExportacion) {
        this.elaboracionDocExportacion = elaboracionDocExportacion;
    }

    public RetiroDeMercancias getRetiroDeMercancias() {
        return retiroDeMercancias;
    }

    public void setRetiroDeMercancias(RetiroDeMercancias retiroDeMercancias) {
        this.retiroDeMercancias = retiroDeMercancias;
    }

    public Preinspeccion getPreinspeccion() {
        return preinspeccion;
    }

    public void setPreinspeccion(Preinspeccion preinspeccion) {
        this.preinspeccion = preinspeccion;
    }

    public Levante getLevante() {
        return levante;
    }

    public void setLevante(Levante levante) {
        this.levante = levante;
    }

    public EntregaDeMercancia getEntregaDeMercancia() {
        return entregaDeMercancia;
    }

    public void setEntregaDeMercancia(EntregaDeMercancia entregaDeMercancia) {
        this.entregaDeMercancia = entregaDeMercancia;
    }

    public List<ValidacionDocumento> getValidacionDocumentos() {
        return validacionDocumentos;
    }

    public void setValidacionDocumentos(List<ValidacionDocumento> validacionDocumentos) {
        this.validacionDocumentos = validacionDocumentos;
    }

    public AnticipoAGirar getAnticipoAGirar() {
        return anticipoAGirar;
    }

    public void setAnticipoAGirar(AnticipoAGirar anticipoAGirar) {
        this.anticipoAGirar = anticipoAGirar;
    }

    public ArriboDeMercancia getArriboDeMercancia() {
        return arriboDeMercancia;
    }

    public void setArriboDeMercancia(ArriboDeMercancia arriboDeMercancia) {
        this.arriboDeMercancia = arriboDeMercancia;
    }

    public PagoDeTributos getPagoDeTributos() {
        return pagoDeTributos;
    }

    public void setPagoDeTributos(PagoDeTributos pagoDeTributos) {
        this.pagoDeTributos = pagoDeTributos;
    }

    public LiberacionDeDocDeTransporte getLiberacionDeDocDeTransporte() {
        return liberacionDeDocDeTransporte;
    }

    public void setLiberacionDeDocDeTransporte(LiberacionDeDocDeTransporte liberacionDeDocDeTransporte) {
        this.liberacionDeDocDeTransporte = liberacionDeDocDeTransporte;
    }

    public List<ElaboracionDeDocDeImportacion> getElaboracionDeDocDeImportacion() {
        return elaboracionDeDocDeImportacion;
    }

    public void setElaboracionDeDocDeImportacion(List<ElaboracionDeDocDeImportacion> elaboracionDeDocDeImportacion) {
        this.elaboracionDeDocDeImportacion = elaboracionDeDocDeImportacion;
    }

    public List<ValidacionVistosBueno> getValidacionVistosBuenos() {
        return validacionVistosBuenos;
    }

    public void setValidacionVistosBuenos(List<ValidacionVistosBueno> validacionVistosBuenos) {
        this.validacionVistosBuenos = validacionVistosBuenos;
    }


    @Override
    public String toString() {
        return "Steps{" +
                ", fechaSalidaMercancia=" + fechaSalidaMercancia + '\'' +
                ", entregaAerolinea=" + entregaAerolinea + '\'' +
                ", validacionVistosBuenos=" + validacionVistosBuenos + '\'' +
                ", solicitudSelectividadDocTransporte=" + solicitudSelectividadDocTransporte + '\'' +
                ", entregaDeDocumentos=" + entregaDeDocumentos + '\'' +
                ", recepcionDeDocumentos=" + recepcionDeDocumentos + '\'' +
                ", validacionDocumentos=" + validacionDocumentos + '\'' +
                ", preinspeccion=" + preinspeccion + '\'' +
                ", retiroDeMercancias=" + retiroDeMercancias + '\'' +
                ", levante=" + levante + '\'' +
                ", anticipoAGirar=" + anticipoAGirar + '\'' +
                ", arriboDeMercancia=" + arriboDeMercancia + '\'' +
                ", entregaDeMercancia=" + entregaDeMercancia + '\'' +
                ", liberacionDeDocDeTransporte=" + liberacionDeDocDeTransporte + '\'' +
                ", pagoDeTributos=" + pagoDeTributos + '\'' +
                ", liberacionDeDocDeTransporte=" + liberacionDeDocDeTransporte + '\'' +
                ", elaboracionDeDocDeImportacion=" + elaboracionDeDocDeImportacion + '\'' +
                '}';
    }
}