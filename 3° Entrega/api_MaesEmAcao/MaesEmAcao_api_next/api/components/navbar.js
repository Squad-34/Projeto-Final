import React from 'react'
import Link from 'next/link'
import style from '../styles/Home.module.css'
import styles from '../styles/Navbar.module.css';

export default function Navbar() {
  return (
    <div className={styles.navbar}>
        <Link href={'/'}> Home</Link>
        <Link href={'/candidatos'}> Candidatos</Link>
        <Link href={'/empresas'}> Empresas</Link>
        <Link href={'/vagas'}> Vagas</Link>
        <Link href={'/experiencias'}> Experiencias</Link>    

    </div>
  )
}
