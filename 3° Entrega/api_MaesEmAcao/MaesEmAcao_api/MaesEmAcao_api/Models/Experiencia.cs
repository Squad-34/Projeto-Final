using System.ComponentModel.DataAnnotations;

namespace MaesEmAcao_api.Models
{
    public class Experiencia
    {
        [Key]
        public int Id { get; set; }
        public string cargo { get; set; }
        public string nome { get; set;}
        public DateTime dataInicio { get; set; }
        public DateTime dataFim { get; set; }
        public int idCandidato { get; set;}
    }
}
