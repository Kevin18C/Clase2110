/* global Swal */

window.onload=function(){
    //let suma = 5+10;
     //alert(suma);
}

function lanzarMensaje(){
    //alert('Hola Mundo');
}

function mostrarVariables(){
    let variable1='texto de pruebas';
    let variable2 = 12345;
    let variableArray=["elemento1", "elemento2"];
    console.log(variable1);
    console.log(variable2);
    console.log(variableArray);
    console.log(variableArray[1]);    
}

function concatenarVariables(var1, var2){   
    let mensaje= var1+var2;
    console.log(mensaje);
}

function mostrarObjetos(var1, var2){
    let producto={"codigo":var1, "nombre_producto":var2}
    console.log(producto);
    console.log(producto.nombre);
}

function mostrarObjetosClasicos(){
    let alumno= new Object();
    alumno.nombre='Angel Vargas';
    alumno.codigo='0909-20-246';
    alumno.correo='correo@umg.edu.gt';
    metodoAnidadoQueMuestraPorConsola(alumno);
    eliminarPropiedadDeObjetos(alumno);
}

function metodoAnidadoQueMuestraPorConsola(unObjeto){
    console.log(unObjeto);
    console.log(unObjeto.nombre);
}

function eliminarPropiedadDeObjetos(objeto){
    delete objeto.correo;
    console.log(objeto);
}

function manipularElementosDelDom(){
    let producto= new Object();
    let codigo=document.getElementById("codigo_producto");
    let nombre=document.getElementById("nombre_producto");
    let precio=document.getElementById("Precio");
    let existencia=document.getElementById("Existencia");
    let fechavencimiento=document.getElementById("Fechavencimiento");
    let id_categoria=document.getElementById("id_categoria");
    let id_marca=document.getElementById("id_marca");
    producto.codigo=codigo_producto.value;
    producto.nombre=nombre_producto.value;
    producto.precio=Precio.value;
    producto.existencia=Existencia.value;
    producto.fechavencimiento=Fechavencimiento.value;
    producto.id_categoria=id_categoria.value;
    producto.id_marca=id_marca.value;
    
    console.log(producto);
    codigo.value='';
    nombre.value='';
    precio.value='';
    existencia.value='';
    fechavencimiento.value='';
    idcategoria.value='';
    idmarca.value='';
    
}

function crearElementosEnEjecusion() {
	let divCreadoEnEjecusion = document.createElement('div');	
	let otroElemento = document.createElement('h4');
	let botones = document.createElement('button');
	otroElemento.append('El titulo deseado');
	divCreadoEnEjecusion.append("texto a agregar");
    botones.setAttribute("value", "Click Aqui");
	let container= document.getElementById("principal");
	container.append(otroElemento);
	container.append(divCreadoEnEjecusion);
	container.append(botones);
 	//console.log(divCreadoEnEjecusion); 		
}

function eliminarElementosEnEjecusion(){
	let container= document.getElementById("principal");
	container.remove();
}

function desestructurarArrays(){
	let miArray=['uno', 'dos','tres'];

	let [a, b, c]=miArray;

	console.log(a);
	console.log(b);
	console.log(c);
}

function manejoDeExcepciones(){
	try{
		algoQueNoExiste();
	}catch(error){
		console.log(error);
		console.error('Errores del try catch');
		console.error(error);
	}
	
}

function enviarFormulario(){
let request = new XMLHttpRequest();
request.open('POST', 'NewServlet', true);
request.setRequestHeader('Content-Type', 'text/plain; charset=UTF-8');

request.onreadystatechange = function() {
  if (request.readyState === XMLHttpRequest.DONE) {
    // Peticion terminada.
    if (request.status === 200) {
      // Todo salio bien
      console.log(request.response);
    } else {
      console.log("Error en el envío " + request.response);
    }
  }
};

var formData = new FormData(document.getElementById('form'));
request.send(formData);
}

function enviarFormularioOpcion2() {
  const XHR = new XMLHttpRequest();
  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
  
  // Define what happens in case of error
  XHR.addEventListener('error', (event) => {
    alert('Oops! Something went wrong.');
  });

  // Set up our request
  XHR.open('POST', 'NewServlet', true);
  XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  
  XHR.onload = () => {
    if (XHR.readyState === XHR.DONE && XHR.status === 200) {
      console.log("response => " + XHR.response);
      document.getElementById('bodyTable').innerHTML = XHR.response;
      mostrarMensaje('Producto guardado exitosamente');
      limpiarFormulario();
    }
  };   
  XHR.send(formData);
}



function limpiarFormulario(){
    document.getElementById("codigo_producto").value='';
    document.getElementById("nombre_producto").value='';
    document.getElementById("Precio").value='';
    document.getElementById("Existencia").value='';
    document.getElementById("Fechavencimiento").value='';
    document.getElementById("id_marca").value='';
    document.getElementById("id_categoria").value='';
}


function mostrarMensaje(mensaje){
  Swal.fire({
    icon: 'success',
    title: mensaje,
    showConfirmButton: false,
    timer: 1500
    });
}

function eliminarproducto(codigo_producto){
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    // Define what happens in case of error
    XHR.addEventListener('error', (event) => {
      alert('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open('POST', 'NewServlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
      if (XHR.readyState === XHR.DONE && XHR.status === 200) {
        console.log("response => " + XHR.response);
        mostrarMensaje('Producto Eliminado exitosamente');
        setTimeout( function() { window.location.reload() }, 2000 );
      }
    };        
    formData.append('codigo', codigo_producto);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData); 
    
}

function mostrarproducto(){
    var control = document.getElementById("control");
    control.value="mostrar";
    const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });
	  // Set up our request
	  XHR.open('POST', 'NewServlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          
          XHR.onload = () => {
            if (XHR.readyState === XHR.DONE && XHR.status === 200) {
              console.log("response => " + XHR.response);
              document.getElementById('bodyTable').innerHTML=XHR.response;
              mostrarMensaje('Productos mostrados exitosamente');
              limpiarFormulario();
            }
          };   
          XHR.send(formData); 
}

function limpiarTabla(){
   var tabla=document.getElementById('tabla1');
   var totalFilas = tabla.rows.length;   
   for (var i = totalFilas -1; i >0; i--){
       tabla.deleteRow(i);
   }
}


