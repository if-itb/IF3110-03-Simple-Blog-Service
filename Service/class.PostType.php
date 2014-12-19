<?php

if(basename($_SERVER['SCRIPT_FILENAME'])==basename(__FILE__))
	exit;

/**
 * PostType
 *
 * @pw_set nillable=false The next element can't be NULL
 * @pw_element int $id
 * @pw_set nillable=false The next element can't be NULL
 * @pw_element string $judul
 * @pw_set nillable=false The next element can't be NULL
 * @pw_element string $konten
 * @pw_set nillable=false The next element can't be NULL
 * @pw_element string $tanggal
 * @pw_element boolean $isPublished
 * @pw_complex PostType - The complex type name definition
 */
class PostType{
	public $id=null;
	public $judul=null;
	public $konten=null;
	public $tanggal=null;
	public $isPublished=false;
}
