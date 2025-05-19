public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = agregarRecursivo(actual.derecho, valor);
        }
        return actual;
    }

    public void inOrden() {
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrdenRec(nodo.derecho);
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrdenRec(nodo.izquierdo);
            preOrdenRec(nodo.derecho);
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(Nodo nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo);
            postOrdenRec(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor ? buscarRec(nodo.izquierdo, valor) : buscarRec(nodo.derecho, valor);
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRec(nodo.izquierdo), alturaRec(nodo.derecho));
    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojasRec(nodo.izquierdo) + contarHojasRec(nodo.derecho);
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRec(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;
            nodo.valor = valorMin(nodo.derecho);
            nodo.derecho = eliminarRec(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    private int valorMin(Nodo nodo) {
        return nodo.izquierdo == null ? nodo.valor : valorMin(nodo.izquierdo);
    }

    public void vaciar() {
        raiz = null;
    }
}
