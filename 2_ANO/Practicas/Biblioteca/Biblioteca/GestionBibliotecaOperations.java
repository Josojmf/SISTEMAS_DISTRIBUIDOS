package Biblioteca;


/**
* Biblioteca/GestionBibliotecaOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Biblioteca.idl
* viernes, 15 de marzo de 2024, 21:05:35 (hora est�ndar de Europa central)
*/


// Define la interfaz para el sistema de gestión de la biblioteca
public interface GestionBibliotecaOperations 
{

  // Busca un libro por título y devuelve los detalles del libro
  Biblioteca.Libro buscarLibro (String titulo);

  // Presta un libro, cambiando su estado a no disponible
  boolean prestarLibro (String ISBN);

  // Devuelve un libro, cambiando su estado a disponible
  boolean devolverLibro (String ISBN);
} // interface GestionBibliotecaOperations
