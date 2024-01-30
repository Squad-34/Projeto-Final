using System.ComponentModel.DataAnnotations;

namespace MaesEmAcao_api.Models
{
    public class Vaga
    {
        [Key]
        public int Id { get; set; }
        public string Descricao { get; set; }
        public string Requisitos { get; set; }
        public string titulo { get; set; }
        public float Salario { get; set; }
        public int IdEmpresa { get; set; }
       
    }
}
