using System.ComponentModel.DataAnnotations;

namespace MaesEmAcao_api.Models
{
    public class Empresa
    {
        [Key]
        public int Id { get; set; }
        public string cnpj { get; set; }
        public string email { get; set; }
        public string nome { get; set; }
        public string telefone { get; set; } 
        public string endereco { get; set; }
    }
}
