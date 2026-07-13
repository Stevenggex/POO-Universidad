package org.spboot.clasespboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // JpaRepository ya incluye por defecto: findAll(), save(), findById(), deleteById()
}
